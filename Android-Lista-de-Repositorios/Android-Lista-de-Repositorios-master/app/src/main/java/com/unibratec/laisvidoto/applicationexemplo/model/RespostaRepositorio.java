package com.unibratec.laisvidoto.applicationexemplo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Laís Vidoto on 02/11/2017.
 */

public class RespostaRepositorio
{
    @SerializedName("items")
    @Expose
    private List<Repositorio> repositories = null;

    @SerializedName("total_count")
    @Expose
    private Integer numRepositories;

//Get's e Set's
    public List<Repositorio> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repositorio> repositories) { this.repositories = repositories; }

    public Integer getNumRepositories() { return numRepositories; }

    public void setNumRepositories(Integer numRepositories) {  this.numRepositories = numRepositories;  }
}
