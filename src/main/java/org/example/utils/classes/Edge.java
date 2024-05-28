package org.example.utils.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Edge<Vertex> {
    private Vertex source;
    private Vertex dest;
    private Double weight;

    public Edge(Vertex source, Vertex dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex dest) {
        this.source = source;
        this.dest = dest;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Edge<?> otherEdge = (Edge<?>) obj;
        return Objects.equals(this.source, otherEdge.source) &&
                Objects.equals(this.dest, otherEdge.dest);
    }
}