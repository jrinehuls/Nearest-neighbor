import java.util.Arrays;
public class ShortestDist {
	
	 public static void main(String[] args) {
		  int row;
		  double distance = 0;
		  double totalDist = 0;
		  //user is at 0,0
		  int locx = 0;
		  int locy = 0;
		  int index = 0;
		  
		  //array to store the location. User is at 0,0
		  int[][] gps = {
		   {-2, 4},
		   {3, 2},
		   {2, 2},
		   {-5, -5},
		   {4, -1},
		  };
		  
		  //while loop to run as long as array is not empty.
		  while(gps.length > 0) {
		  //loop through the array
			  double shortestDistance = distance(gps[0][0], locx, gps[0][1], locy);
			  //double shortestDistance = 1000;
			  for(row = 1; row < gps.length; row++) {
				  distance = distance(gps[row][0], locx, gps[row][1], locy);
				  if(distance <= shortestDistance) {
					  index = row;
					  shortestDistance = distance;
				  }
			  }
		    
		  locx = gps[index][0];
		  locy = gps[index][1];
		  
		  System.out.println("The nearest point is " + "(" + locx + "," + locy + ")");
		  System.out.println("The row of this element is " + index);
		  System.out.println("The distance is " + shortestDistance);
		  System.out.println("You are now at " + "(" + locx + "," + locy + ")");
		  //shrink array using method call
		  gps = removeElement(gps, index);
		  //reset index THIS IS SUPER IMPORTANT!!!!
		  index = 0;
		  
		  System.out.println("Points left to visit: " + Arrays.deepToString(gps) + "\n");
		  totalDist += shortestDistance;
		  }
		  System.out.println("The total distance traveled is: " + totalDist);
	 }

	//Method uses Pythagorean theorem to calculate distance.
	 public static double distance(int xf, int xi, int yf, int yi) {
		  return Math.sqrt((Math.pow(xf - xi, 2) + Math.pow(yf - yi, 2)));
	 }
	 
	 //removeElement method.
	 private static int[][] removeElement(int[][] gps, int index) {
		if(gps == null || index < 0 || index >= gps.length) {
			System.out.println("Invalid array or index");
		}
		//Declare new array to be returned to GPS in main method.
		int[][] temp = new int[gps.length-1][2];
		for(int i = 0, j = 0; i<gps.length; i++) {
			//Continue breaks from a loop once and returns back into loop. This throws away the matching row.
			if(i == index) {
				continue;
			}
			//Assigning old gps indeces to temp indeces.
			temp[j][0] = gps[i][0];
			temp[j][1] = gps[i][1];
			j++;	
		}
		return temp;
	 }
}
