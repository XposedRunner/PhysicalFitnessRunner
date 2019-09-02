package org.jsoup.select;

import org.jsoup.nodes.Node;

public class NodeTraversor {
    private NodeVisitor O000000o;

    public NodeTraversor(NodeVisitor nodeVisitor) {
        this.O000000o = nodeVisitor;
    }

    public void O000000o(Node node) {
        Node node2 = node;
        int i = 0;
        while (node2 != null) {
            this.O000000o.O000000o(node2, i);
            if (node2.O000Oo0o() > 0) {
                node2 = node2.O00000oO(0);
                i++;
            } else {
                while (node2.O000Oooo() == null && i > 0) {
                    this.O000000o.O00000Oo(node2, i);
                    node2 = node2.O00O0Oo();
                    i--;
                }
                this.O000000o.O00000Oo(node2, i);
                if (node2 != node) {
                    node2 = node2.O000Oooo();
                } else {
                    return;
                }
            }
        }
    }
}
