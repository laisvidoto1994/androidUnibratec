package com.unibratec.laisvidoto.applicationexemplo.interfaces;

import com.unibratec.laisvidoto.applicationexemplo.model.PullRequest;
import com.unibratec.laisvidoto.applicationexemplo.model.RespostaRepositorio;
import com.unibratec.laisvidoto.applicationexemplo.model.Usuario;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Laís Vidoto on 02/11/2017.
 */

public interface Services
{
    @GET("search/repositories?q=language:Java&sort=stars")
    Call<RespostaRepositorio> getRepositories(@Query("page") Integer page);

    @GET("repos/{user}/{repo}/pulls")
    Call<List<PullRequest>>getPullRequests(@Path("user") String userName, @Path("repo") String repoName);

    @GET("users/{user}")
    Call<Usuario> getUser(@Path("user") String username);
}
