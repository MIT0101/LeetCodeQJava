import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem_Hard {
    //problem (218/2422)

//    Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//    Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
public static void main(String[] args) {
    System.out.println();

    int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

    List<List<Integer>> result=getSkyline(buildings);

    for (List<Integer> singleResult:result) {
        System.out.println(Arrays.toString(singleResult.toArray()));

    }

}
    public static List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result=new ArrayList<>();
        SingleBuilding prevase=null;
        for (int i = 0; i < buildings.length; i++) {
            List<Integer> singleResult=new ArrayList<>();
            SingleBuilding currentBuilding=new SingleBuilding(
                    buildings[i][0]
                    ,buildings[i][1]
                    ,buildings[i][2]
            );

            if(i== buildings.length-1){
                System.out.println();
            }

            //when prevas is higher than current
            if(prevase!=null&&prevase.xStart<=currentBuilding.xStart&&currentBuilding.xStart<= prevase.xEnd){
//                singleResult.add(prevase.xEnd,building.heghit);
                if(prevase.xEnd<= currentBuilding.xEnd){
                    singleResult.add(prevase.xEnd);
                    singleResult.add(currentBuilding.heghit);
                }
                else if(currentBuilding.xStart>= prevase.xStart){
                    singleResult.add(currentBuilding.xStart);
                    singleResult.add(currentBuilding.heghit);
                }
            }
//            else if(prevase!=null &&currentBuilding.xStart> prevase.xEnd){
//
//            }

            //for add hight 0 for bulding that not connect to next one when we are in next bulding
            if(prevase!=null &&currentBuilding.xStart> prevase.xEnd){
                singleResult.add(prevase.xEnd);
                singleResult.add(0);
            }
//            else if(prevase!=null){
//                singleResult.add(prevase.xEnd);
//                singleResult.add(currentBuilding.heghit);
//            }
            //for last buliding
            if(prevase==null&&i!= buildings.length-1){
                singleResult.add(currentBuilding.xStart);
                singleResult.add(currentBuilding.heghit);

            }
            else if(prevase!=null&&i== buildings.length-1){
                singleResult.add(currentBuilding.xEnd);
                singleResult.add(0);
            }
            if(singleResult.size()>0){
                result.add(singleResult);
            }
            prevase=currentBuilding;
        }
        return result;
    }
    public static   class SingleResult{
        int x;
        int y;

        public  SingleResult(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static   class SingleBuilding{
     int xStart;
     int xEnd;
     int heghit;
        public SingleBuilding(int xStart, int xEnd, int heghit) {
            this.xStart = xStart;
            this.xEnd = xEnd;
            this.heghit = heghit;
        }
    }

}


