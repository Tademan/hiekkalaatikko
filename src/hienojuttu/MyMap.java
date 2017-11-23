/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hienojuttu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Taavi
 */
public class MyMap {

    private NodeType[][] map;
    int korkeus, leveys;
    Random arpoja = new Random();

    public MyMap(int x, int y, int mode) {
        this.korkeus = y;
        this.leveys = x;
        map = new NodeType[x][y];
        if (mode == 0) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    map[i][j] = NodeType.AIR;
                }
            }
        }
        if (mode == 1) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    int luku = arpoja.nextInt(7);
                    if (luku == 0) {
                        map[i][j] = NodeType.AIR;
                    }
                    if (luku == 1) {
                        map[i][j] = NodeType.FIRE;
                    }
                    if (luku == 2) {
                        map[i][j] = NodeType.HELIUM;
                    }
                    if (luku == 3) {
                        map[i][j] = NodeType.HYDROGEN;
                    }
                    if (luku == 4) {
                        map[i][j] = NodeType.SAND;
                    }
                    if (luku == 5) {
                        map[i][j] = NodeType.WATER;
                    }
                    if (luku == 6) {
                        map[i][j] = NodeType.STONE;
                    }
                    

                }
            }
        }
    }

    public MyMap(int x, int y, int mode, MyMap.NodeType type) {
        this.korkeus = y;
        this.leveys = x;
        map = new NodeType[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = type;
            }
        }
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void simuloi() {
        List<Integer> iit = new ArrayList<>();
        for (int i = 0; i < this.leveys; i++) iit.add(i);
        Collections.shuffle(iit);
        List<Integer> jiit = new ArrayList<>();
        for (int i = 0; i < this.leveys; i++) jiit.add(i);
        Collections.shuffle(jiit);
        
        for (int i : iit) {
            for (int j : jiit) {
                if (this.getNode(i, j) == MyMap.NodeType.SAND) {
                    int r = arpoja.nextInt(3) - 1;
                    MyMap.NodeType type = this.getNode(i + r, j + 1);
                    if ((type == MyMap.NodeType.AIR)) {
                        this.setNode(i + r, j + 1, MyMap.NodeType.SAND);
                        this.setNode(i, j, MyMap.NodeType.AIR);
                    }
                    if ((type == MyMap.NodeType.WATER)) {
                        this.setNode(i + r, j + 1, MyMap.NodeType.SAND);
                        this.setNode(i, j, MyMap.NodeType.WATER);

                    }

                }
                if (this.getNode(i, j) == MyMap.NodeType.HELIUM) {
                    int r1 = arpoja.nextInt(3) - 1;
                    int r2 = arpoja.nextInt(2);
                    MyMap.NodeType type = this.getNode(i + r1, j - r2);
                    if ((type == MyMap.NodeType.AIR)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HELIUM);
                        this.setNode(i, j, MyMap.NodeType.AIR);
                    }
                    if ((type == MyMap.NodeType.WATER)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HELIUM);
                        this.setNode(i, j, MyMap.NodeType.WATER);
                    }
                    if ((type == MyMap.NodeType.SAND)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HELIUM);
                        this.setNode(i, j, MyMap.NodeType.SAND);
                    }
                }
                if (this.getNode(i, j) == MyMap.NodeType.HYDROGEN) {
                    int r1 = arpoja.nextInt(3) - 1;
                    int r2 = arpoja.nextInt(2);
                    MyMap.NodeType type = this.getNode(i + r1, j - r2);
                    if ((type == MyMap.NodeType.AIR)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HYDROGEN);
                        this.setNode(i, j, MyMap.NodeType.AIR);
                    }
                    if ((type == MyMap.NodeType.WATER)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HYDROGEN);
                        this.setNode(i, j, MyMap.NodeType.WATER);
                    }
                    if ((type == MyMap.NodeType.SAND)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HYDROGEN);
                        this.setNode(i, j, MyMap.NodeType.SAND);
                    }
                    if ((type == MyMap.NodeType.HELIUM)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.HYDROGEN);
                        this.setNode(i, j, MyMap.NodeType.HELIUM);
                    }
                    if ((type == MyMap.NodeType.FIRE)) {
                        this.setNode(i + r1, j - r2, MyMap.NodeType.WATER);
                        this.setNode(i, j, MyMap.NodeType.WATER);
                    }

                }
                if (this.getNode(i, j) == MyMap.NodeType.FIRE) {

                    int r1 = arpoja.nextInt(3) - 1;
                    int r2 = arpoja.nextInt(3) - 1;
                    MyMap.NodeType type = this.getNode(i + r1, j + r2);
                    if ((type == MyMap.NodeType.WATER)) {
                        this.setNode(i + r1, j + r2, MyMap.NodeType.WATER);
                        this.setNode(i, j, MyMap.NodeType.SAND);
                    }

                    if ((type == MyMap.NodeType.AIR)) {
                        this.setNode(i + r1, j + r2, MyMap.NodeType.FIRE);
                        this.setNode(i, j, MyMap.NodeType.AIR);

                    }
                    if ((type == MyMap.NodeType.HELIUM)) {
                        this.setNode(i + r1, j + r2, MyMap.NodeType.FIRE);
                        this.setNode(i, j, MyMap.NodeType.HELIUM);

                    }
                    if ((type == MyMap.NodeType.HYDROGEN)) {
                        this.setNode(i + r1, j + r2, MyMap.NodeType.FIRE);
                        this.setNode(i, j, MyMap.NodeType.HYDROGEN);

                    }
                }

                if (this.getNode(i, j) == MyMap.NodeType.WATER) {
                    if (this.getNode(i, j + 1) == MyMap.NodeType.AIR) { //jos alapuolella on ilmaa se tippuu
                        int r1 = arpoja.nextInt(3) - 1;
                        if (this.getNode(i + r1, j + 1) == MyMap.NodeType.AIR) {
                            this.setNode(i + r1, j + 1, MyMap.NodeType.WATER);
                            this.setNode(i, j, MyMap.NodeType.AIR);
                        }
                    } else if (this.getNode(i, j + 1) == MyMap.NodeType.WATER) { //jos yläpuolella on vettä
                        int r1 = arpoja.nextInt(13) - 6;
                        if (this.getNode(i + r1, j) == MyMap.NodeType.AIR) {
                            this.setNode(i + r1, j, MyMap.NodeType.WATER);
                            this.setNode(i, j, MyMap.NodeType.AIR);
                        }
                    }

                }

            }
        }
    }

    public void setNode(int x, int y, NodeType type) {
        if (this.isWithinMap(x, y)) {
            map[x][y] = type;
        }
    }

    public boolean isWithinMap(int x, int y) {
        return x >= 0 && x < leveys && y >= 0 && y < korkeus;
    }

    public NodeType getNode(int x, int y) {
        if (this.isWithinMap(x, y)) {
            return map[x][y];
        } else {
            return MyMap.NodeType.STONE;

        }
    }

    public enum NodeType {
        AIR(0),
        SAND(1),
        STONE(2),
        WATER(4),
        HELIUM(5),
        HYDROGEN(6),
        FIRE(7);

        public static NodeType nodeTypeFromByte(byte i) {
            for (NodeType t : values()) {
                if (t.getCode() == i) {
                    return t;
                }
            }
            return null;
        }

        private byte code;

        private NodeType(int code) {
            this.code = (byte) code;
        }

        public byte getCode() {
            return code;
        }
    }

}
