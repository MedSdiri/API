import io.restassured.path.json.JsonPath;

import org.testng.Assert;

import files.payload;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      JsonPath js = new JsonPath(payload.coursePrice());
	  //1. Print No of courses returned by API
      int count = js.getInt("courses.size()");
      System.out.println(count);
      
      //2.Print Purchase Amount
      int purAmount = js.getInt("dashboard.purchaseAmount");
      System.out.println(purAmount);
      
      //3. Print Title of the first course
      String firstTitle = js.getString("courses[0].title");
      System.out.println(firstTitle);
      System.out.println("-------------");
      
      //4. Print All course titles and their respective Prices
      for(int i=0; i < js.getInt("courses.size()"); ++i) {
    	  System.out.print(js.getString("courses["+i+"].title"));
    	  System.out.println(" -- "+js.getInt("courses["+i+"].price"));
      }
      System.out.println("---------------");
      //5. Print no of copies sold by RPA Course
      for(int i=0; i < js.getInt("courses.size()"); ++i) {
    	  
    	  if(js.getString("courses["+i+"].title").equals("RPA")){
    	  System.out.println(js.getInt("courses["+i+"].copies")+" copies of RPA");
      }
	}
      System.out.println("----------------");
      //6. Verify if Sum of all Course prices matches with Purchase Amount
      int actualAmount =0;
      int expectedAmount = js.getInt("dashboard.purchaseAmount");
      for(int i=0; i < js.getInt("courses.size()"); ++i) {
    	  
    	 actualAmount += js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies");
      }
      
      Assert.assertEquals(actualAmount, expectedAmount, "Failed again, call RAMIZ SM again");


      
      
      
      


		
	}

}


/*
1. Print No of courses returned by API
2.Print Purchase Amount
3. Print Title of the first course
4. Print All course titles and their respective Prices
5. Print no of copies sold by RPA Course
6. Verify if Sum of all Course prices matches with Purchase Amount

*/