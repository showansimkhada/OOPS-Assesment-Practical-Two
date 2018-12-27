//Student name: Showan Simkhada
//Student ID: 17459655
//Pledge of Honor: I pledge by honor that this program is solely my own work.

package application;

public class Question_No2 
{
	
	public static void main(String[] args)
	{
		// creating the note array
		Note[] noteArray = new Note[5];
		noteArray[0] = new Note("D", 19);
		noteArray[1] = new Note("C", 20);
		noteArray[2] = new Note("F", 31);
		noteArray[3] = new Note("B", 45);
		noteArray[4] = new Note("C", 73);
		processNotes(noteArray);
	}
	
	public static void processNotes(Note[] notes)
	{
		// for calculating the total seconds 
		int total = 0;
		for (int i = 0; i < notes.length; i++)
		{
			notes[i].playNote();
			total = notes[i].getDuration() + total;
		}
		System.out.println("Total duration of notes: " + total + " seconds.");
	}
	
}

class Note
{
	private String Pitch;
	private int Duration;
	// creating the note constructor with two parameters
	Note(String Pitch, int Duration)
	{
		this.Pitch = Pitch;
		this.Duration = Duration;
	}
	
	// creating getters and setters for the pitch and duration
	public String getPitch() 
	{
		return Pitch;
	}
	
	public void setPitch(String pitch) 
	{
		Pitch = pitch;
	}
	
	public int getDuration() 
	{
		return Duration;
	}
	
	public void setDuration(int duration) 
	{
		Duration = duration;
	}
	
	public void playNote()
	{
		System.out.printf("The note " + getPitch() + " is played for " + getDuration() + " seconds.\n");
	}
	
}
