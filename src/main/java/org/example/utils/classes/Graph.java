package org.example.utils.classes;

import java.util.*;

public class Graph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Vertex>> map;

    public Graph(){
        this(true);
    }

    public Graph(boolean undirected){
        this.undirected = undirected;
        map = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if(hasVertex(v)) return;
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex s, Vertex d) {
        if(!hasVertex(s)) addVertex(s);
        if(!hasVertex(d)) addVertex(d);

        if(hasEdge(s, d) || s.equals(d)) return;

        map.get(s).add(d);
        if(undirected) map.get(d).add(s);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for(Vertex v : map.keySet()) count += map.get(v).size();
        return undirected ? count / 2 : count;
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex s, Vertex d) {
        if(!hasVertex(s)) return false;
        return map.get(s).contains(d);
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if(hasVertex(v)) return null;
        return map.get(v);
    }
}