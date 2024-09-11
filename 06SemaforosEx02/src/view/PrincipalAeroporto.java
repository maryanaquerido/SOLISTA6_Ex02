package view;
import controller.ControllerAeroporto;
public class PrincipalAeroporto {
	public static void main (String[]args) {
		
		for (int i = 0; i<12; i++) {
			ControllerAeroporto thread = new ControllerAeroporto ();
			thread.start();
		}
	}
}
