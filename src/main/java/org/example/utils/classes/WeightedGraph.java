package org.example.utils.classes;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map;

    public WeightedGraph(){
        this(true);
    }

    public WeightedGraph(boolean undirected){
        this.undirected = undirected;
        map = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        if(hasVertex(v)) {
            return;
        }

        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex s, Vertex d) {
        throw new UnsupportedOperationException("You should use addEdge(classes.Vertex, classes.Vertex, Double) in weighted graph.");
    }

    public void addEdge(Vertex s, Vertex d, Double weight){
        if(!hasVertex(s)) {
            addVertex(s);
        };
        if(!hasVertex(d)) {
            addVertex(d);
        }
        if(hasEdge(s, d) || s.equals(d)) {
            return;
        }
        map.get(s).add(new Edge<>(s, d, weight));
        if(undirected) {
            map.get(d).add(new Edge<>(d, s, weight));
        }
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
        return map.get(s).contains(new Edge<>(s, d));
    }

    public List<Vertex> adjacencyList(Vertex v) {
        if(!hasVertex(v)) return null;

        List<Vertex> vertices = new LinkedList<>();
        for(Edge<Vertex> e : map.get(v)) vertices.add(e.getDest());

        return vertices;
    }

    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        if(!hasVertex(v)) return null;

        return map.get(v);
    }
}