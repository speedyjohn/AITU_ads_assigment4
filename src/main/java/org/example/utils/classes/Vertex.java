package org.example.utils.classes;

import lombok.Getter;

import java.util.Map;

public class Vertex<T> {
    private T data;
    @Getter
    private Map<Vertex<T>, Double> adjacentVertices;

    public void addAdjacentVertex(Vertex<T> dest, double weight){
        adjacentVertices.put(dest, weight);
    }

}