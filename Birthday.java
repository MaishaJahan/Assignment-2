import javax.swing.JOptionPane;
import java.util.Random;

public class Birthday {

	public static void main(String[] args) {
		String answer, toy, ans, name, stringAge;
		String myName = "Maisha Jahan";
		Random r = new Random();
		Double totalCost = 0.0;
		
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company"
					+ " to choose gifts for young children.");
		do {
			Toy a = new Toy();
			name = JOptionPane.showInputDialog("Enter the name of the child.");
			stringAge = JOptionPane.showInputDialog("How old is the child?");
			int age = Integer.parseInt(stringAge);
			a.setAge(age);
			
			toy = JOptionPane.showInputDialog("Choose a toy: plushie, blocks, or a book.");
			a.setToy(toy);
			while (toy.equals("plushie") == false && toy.equals("blocks") == false && 
					toy.equals("book") == false )
			{
				toy = JOptionPane.showInputDialog("Invalid Input. Enter a vaild toy: plushie"
						+ " blocks, or book");
				a.setToy(toy);
			}

			if (a.ageOK()==true)
			{
				JOptionPane.showMessageDialog(null, "Good Choice!");
			}
			if (a.ageOK() == false)
			{
				ans = JOptionPane.showInputDialog("Toy is not age appropriate. Do you want "
						+ "a different toy? (y/n)");
				if (ans.equals("y"))
				{
					toy = JOptionPane.showInputDialog("Choose a toy: plushie, blocks, or a book.");
					a.setToy(toy);
					while (toy.equals("plushie") == false && toy.equals("blocks") == false && 
							toy.equals("book") == false )
					{
						toy = JOptionPane.showInputDialog("Invalid Input. Enter a vaild toy: plushie"
								+ " blocks, or book");
						a.setToy(toy);
					}
				}
			}
			a.setToy(toy);
			a.setCost(toy);
			answer = JOptionPane.showInputDialog("Do you want a card? (yes/no)");
			a.addCard(answer);

			answer = JOptionPane.showInputDialog("Do you want balloons? (yes/no)");
			a.addBalloon(answer);
			
			
			totalCost += a.getCost();
			
			JOptionPane.showMessageDialog(null,"Gift for " + name + a.toString());
			answer = JOptionPane.showInputDialog("Do you want to add another toy? (y/n)");
		}while (answer.equals("y"));

		JOptionPane.showMessageDialog(null, "Tracking Number: " + (r.nextInt(10000)+1) + " "
				+ "Total Cost: $" + totalCost + " Programmer: " + myName );

	}

}