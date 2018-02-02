package ru.vladislav;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by vladi on 02.02.2018.
 */

public class MenuScreen extends Base2DScreen {
    private int x,y,screenX, screenY, tmpX, tmpY;
    private SpriteBatch batch;
    private Texture background, logo;
    int count = 0;

    public MenuScreen(Game game){
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        background = new Texture("bg.png");
        logo = new Texture("badlogic.jpg");
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.7f,0.3f,0.7f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background,0,0);
        batch.draw(logo,x,y);
        batch.end();
        if (count<60){
            x+=tmpX;
            y+=tmpY;
            count++;
        }
      //  else count=0;
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        this.screenX=screenX;
        this.screenY=Gdx.graphics.getHeight() - screenY;
        tmpX = (screenX-x)/60;
        tmpY = (this.screenY-y)/60;
        count = 0;
        return super.touchDown(screenX, screenY, pointer, button);

    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        super.dispose();
    }
}
