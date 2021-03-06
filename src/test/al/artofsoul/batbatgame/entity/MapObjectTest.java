package al.artofsoul.batbatgame.entity;

import al.artofsoul.batbatgame.tilemap.TileMap;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapObjectTest {

    @Test
    public void checkTileMapCollision() {
        //setup
        TileMap tm = new TileMap(200);
        MapObject obj = new MapObject(tm);
        obj.setPosition(12.5, -1);
        obj.setVector(20.15,10.5);
        obj.cwidth = 100;
        obj.cheight = 100;
        obj.tileSize = 200;
        obj.falling = false;
        obj.bottomLeft = false;
        obj.bottomRight = false;
        //run function
        obj.checkTileMapCollision();

        //assert statements
        assertEquals(obj.x, obj.xtemp, 0.001); //expected true, both values are the same
        assertEquals(obj.y, obj.ytemp, 0.001); //expected true

        assertEquals(0.065, obj.currCol, 0.000); //expected false, currCol is int
        assertEquals(0, obj.currCol); //expected true
        assertEquals(-1, obj.currRow); // expected false, is 0

        assertTrue(obj.falling); //expected true, because changed after condition check
    }
}