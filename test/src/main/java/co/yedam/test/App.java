package co.yedam.test;

import co.yedam.test.member.menu.MemberMenu;

public class App 
{
    public static void main( String[] args )
    {
//      SHA256 sha256 = new SHA256();
//    System.out.println(sha256.encrypt("5678"));
   
      MemberMenu menu = new MemberMenu();
//    	MainMenu menu = new MainMenu();
    	menu.run();
    }
}
