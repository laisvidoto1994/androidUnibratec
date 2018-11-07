package com.unibratec.laisvidoto.applicationexemplo.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.unibratec.laisvidoto.applicationexemplo.R;
import com.unibratec.laisvidoto.applicationexemplo.adapter.RepoAdapter;
import com.unibratec.laisvidoto.applicationexemplo.interfaces.Services;
import com.unibratec.laisvidoto.applicationexemplo.model.Repositorio;
import com.unibratec.laisvidoto.applicationexemplo.model.RespostaRepositorio;
import com.unibratec.laisvidoto.applicationexemplo.util.Api;

public class MainActivity extends AppCompatActivity
{
    private RepoAdapter adapter;
    private RecyclerView listaRepositorio;
    private Services gitServices;
    private ProgressBar progressBar;
    private boolean isLoading = false;
    private int currentPage   = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gitServices      = Api.getGitService();
        progressBar      = (ProgressBar) findViewById(R.id.progressBar);
        listaRepositorio = (RecyclerView) findViewById(R.id.listaRepositorios);

        /* Configuração do Adapter */
        adapter = new RepoAdapter(this, new ArrayList<Repositorio>(0), new RepoAdapter.RepositoryListener()
        {
                    @Override
                    public void onRepositoryClick(String authorName, String repoName)
                    {

                        Intent intent =  new Intent(getApplicationContext(), activity_pull.class);
                        intent.putExtra("authorName", authorName);
                        intent.putExtra("repoName", repoName);
                        startActivity(intent);
                    }
         });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaRepositorio.setLayoutManager(layoutManager);
        listaRepositorio.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        listaRepositorio.addItemDecoration(itemDecoration);

        if (savedInstanceState != null)
        {
            List<Repositorio> repositories = (List<Repositorio>) savedInstanceState.getSerializable("repositories");
            adapter.updateRepositories(repositories);
            this.currentPage = savedInstanceState.getInt("currentPage");
        }

        listaRepositorio.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);

                isLoading = true;
                int pastVisibleItems, visibleItemsCount, totalItemCount;

                if (dy > 0)
                {
                    visibleItemsCount = layoutManager.getChildCount();
                    pastVisibleItems  = layoutManager.findFirstVisibleItemPosition();
                    totalItemCount    = layoutManager.getItemCount();

                    if (isLoading)
                    {
                        if ((visibleItemsCount + pastVisibleItems) >= totalItemCount)
                        {
                            isLoading = false;
                            progressBar.setVisibility(View.VISIBLE);
                            loadRepositories(++currentPage);
                        }
                    }
                }
            }
        });

        listaRepositorio.setAdapter(adapter);
    }

    public void loadRepositories(int page)
    {
        gitServices.getRepositories(page).enqueue(new Callback<RespostaRepositorio>()
        {
            @Override
            public void onResponse(Call<RespostaRepositorio> call, Response<RespostaRepositorio> response)
            {
                if (response.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);
                    adapter.addAll(response.body().getRepositories());
                    Log.d("MainActivity", "Repositorios carregados.");
                }
            }

            @Override
            public void onFailure(Call<RespostaRepositorio> call, Throwable t)
            {
                Toast.makeText(getApplicationContext(), "Carregamento inadequado", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                Log.e("MainActivity", "Erro no API!");
            }

        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        loadRepositories(currentPage);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putSerializable("repositories", (Serializable) adapter.getRepositories());
        outState.putInt("currentPage", currentPage);
    }
}
