package project_2;

import java.util.Timer;
import java.util.TimerTask;

public class Spawner {

	Timer spawn_timer = new Timer();;
	int count = 0;
	private Obstacle[] obstacles = new Obstacle[10];

	float SCREEN_X, SCREEN_Y;
	static int OBS_SCALE = 30;

	int min = 5;
	int max = 10;
	int randomNumber;

	float GROUND_GAP;
	

	public Spawner(float SCREEN_X, float SCREEN_Y, float GROUND_GAP)
	{
		// Initialize first so that it is not null
		for(int i=0; i < obstacles.length ; i++)
		{
			randomNumber = (int) (Math.random() * (max - min + 1)) + min;

			float OBS_POS[] = {SCREEN_X,OBS_SCALE + randomNumber*3, SCREEN_Y - GROUND_GAP - (OBS_SCALE+randomNumber*3)};
			float OBS_RECT[] = {OBS_SCALE,OBS_SCALE + randomNumber*3};

			obstacles[i] = new Obstacle(OBS_RECT[0],OBS_RECT[1],OBS_POS[0],OBS_POS[1]);
			obstacles[i].move(false);
		}

		this.SCREEN_Y = SCREEN_Y;
		this.SCREEN_X = SCREEN_X;
		this.GROUND_GAP = GROUND_GAP;
	}

	TimerTask task = new TimerTask() 
	{
		@Override
		public void run() {
			if(count < 9)
			{
				respawn(count);
				obstacles[count].move(true);
				count++;
			}
			else if (count==9)
			{
				count = 0;
			}
			//System.out.println("spawn "+ count);
		}
	};

	void respawn(int i)
	{
		randomNumber = (int) (Math.random() * (max - min + 1)) + min;
		obstacles[i] = new Obstacle(OBS_SCALE,OBS_SCALE+randomNumber*3,SCREEN_X,(SCREEN_Y-GROUND_GAP - (OBS_SCALE+randomNumber*3)));
	}

	public void addSpawnTimer()
	{
		//System.out.println("timer ");
		spawn_timer.schedule(task, 1000, 2000);
	}

	public boolean gameOver(Player p, int i) // check ...
	{
		if(p.getBounds().intersects(obstacles[i].getBounds()))
		{
			//how to pause timer
			//spawn_timer.cancel();
			
			// Initialize first so that it is not null
			for(int j=0; j < obstacles.length ; j++)
			{
				randomNumber = (int) (Math.random() * (max - min + 1)) + min;

				obstacles[j] = new Obstacle(OBS_SCALE,OBS_SCALE+randomNumber*3,SCREEN_X,(SCREEN_Y-GROUND_GAP - (OBS_SCALE+randomNumber*3)));
				
				obstacles[j].move(false);
			}
			
			
			return true;
		}

		return false;
	}


	public Obstacle[] getObstacle()
	{
		return obstacles;
	}

}
