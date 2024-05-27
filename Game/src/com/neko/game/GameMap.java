package com.neko.game;

import com.neko.graphics.Sprite;
import com.neko.resources.Resources;

import java.util.Random;

public class GameMap {
    
    
    private int wTiles;
    private int hTiles;
    public Tile[] tiles;
    public GameMap(int w, int h) {
        tiles = new Tile[w*h];
        wTiles = w;
        hTiles = h;
        for (int x = 0; x < wTiles; x++) {
            for (int y = 0; y < hTiles; y++) {
                Random rand = new Random();
                int n = rand.nextInt(Resources.grass_tiles.length);
                tiles[x+y*h] = new Tile("tile", Resources.grass_tiles[n],x*16,y*16,16,16);
            }
        }
    }
}
