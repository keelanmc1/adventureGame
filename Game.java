import java.awt.Color;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 

public class Game
{
    JFrame window; 
    Container con ;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel; 
    JLabel prompt, healthLabel, healthLabelNumber, weaponLabel, typeWeaponLabel, monsterHealthLabel, monsterHealthNumber; 
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90 ); 
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30); 
    JButton startButton, choice1, choice2, choice3, choice4; 
    JTextArea mainTextArea; 
    int playerHealth; 
    String playerWeapon, position; 

    TitleScreenHandler tsHandler = new TitleScreenHandler(); 
    ChoiceHandler choiceHandler = new ChoiceHandler(); 
    public static void main (String [] args)
    {
        new Game(); 
    }

    public Game()
    {
        window = new JFrame("Adventure"); 
        window.setSize(800,600); 
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black); 
        window.setLayout(null); 

        con = window.getContentPane(); 

        titleNamePanel = new JPanel(); 
        titleNamePanel.setBounds(100,100,600,150); 
        titleNamePanel.setBackground(Color.black);

        prompt = new JLabel("Adventure");
        prompt.setForeground(Color.white); 
        prompt.setFont(titleFont);

        startButtonPanel = new JPanel(); 
        startButtonPanel.setBounds(300,400,200,100); 
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.WHITE); 
        startButton.setForeground(Color.BLACK);
        startButton.setFont(normalFont); 
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        startButtonPanel.add(startButton); 
        titleNamePanel.add(prompt); 

        con.add(titleNamePanel);
        con.add(startButtonPanel); 
    }

    //main gameplay method 
    public void createGamePlay()
    {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel(); 
        mainTextPanel.setBounds(100,100,650,250);
        mainTextPanel.setBackground(Color.BLACK);

        mainTextArea = new JTextArea("Howdy there! welcome to the game!"); 
        mainTextArea.setBounds(100,100,600,250); 
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont); 
        mainTextArea.setLineWrap(true);

        choiceButtonPanel = new JPanel(); 
        choiceButtonPanel.setBounds(250,350,300,150); 
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(4,1));

        choice1 = new JButton("choice 1"); 
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont); 
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1); 

        choice2 = new JButton("choice 2"); 
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont); 
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("choice 3"); 
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3); 

        choice4 = new JButton("choice 4"); 
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont); 
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4); 

        playerPanel = new JPanel(); 
        playerPanel.setBounds(100, 15, 600, 50); 
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel); 

        mainTextPanel.add(mainTextArea);
        con.add(mainTextPanel); 
        con.add(choiceButtonPanel);
        
        healthLabel = new JLabel("HP:"); 
        healthLabel.setFont(normalFont); 
        healthLabel.setForeground(Color.white);
        playerPanel.add(healthLabel); 

        healthLabelNumber = new JLabel(); 
        healthLabelNumber.setFont(normalFont); 
        healthLabelNumber.setForeground(Color.white);
        playerPanel.add(healthLabelNumber); 

        weaponLabel = new JLabel("Weapon:"); 
        weaponLabel.setFont(normalFont); 
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel); 

        typeWeaponLabel = new JLabel(); 
        typeWeaponLabel.setFont(normalFont); 
        typeWeaponLabel.setForeground(Color.white);
        playerPanel.add(typeWeaponLabel); 

        playerSetup();

    }

    public void playerSetup()
    {
        playerHealth = 20; 
        playerWeapon = "Knife"; 
        typeWeaponLabel.setText(playerWeapon);
        healthLabelNumber.setText(""+playerHealth);

        townGate();
    }

    public void townGate()
    {
        position = "townGate"; 
        mainTextArea.setText("You are at a towns gate... you are confronted by a guard... what do you do?");
        choice1.setText("Talk to the guard"); 
        choice2.setText("Attack the guard"); 
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkToGuard()
    {
        position = "talkGuard"; 
        mainTextArea.setText("Guard: I have never seen you before in my life... This town is off limits to non residence!");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText(""); 
    }

    public void attackGuard()
    {
        position = "attackGuard"; 
        mainTextArea.setText("Guard: Owch! \n\nThe guard attacks back taking 5 HP damage\n\nGuard: Dont try that again!...");
        playerHealth = playerHealth - 5; 
        healthLabelNumber.setText(""+playerHealth);
        choice1.setText("Talk to the guard");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText(""); 
    }

    public void leaveTown()
    {
        position = "leaveTown"; 
        mainTextArea.setText("You have left the town and encountered\n a cross road that goes either north, south, west or east... \n\nWhat do you do?"); 
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go west"); 
    }

    public void goNorth()
    {
        position = "north"; 
        mainTextArea.setText("You have encountered a chest....\nYou open it and find a sword\nYou add this to you collection!\n\nWhat do you do next?"); 
        choice1.setText("Go South");
        choice2.setText("");
        choice3.setText("");
        choice4.setText(""); 
        playerWeapon = "Sword"; 
        typeWeaponLabel.setText("Sword"); 
    }

    public void goWest()
    {
        position = "west"; 
        mainTextArea.setText("You have wondered far into the forest...\nIt gets very cold as the sun sets\nYou see an abdandoned house\n\nWhat do you do?");
        choice1.setText("Seek shelter");
        choice2.setText("Go back east");
        choice3.setText("");
        choice4.setText(""); 

    }

    public void seekShelter()
    {
        position = "shelter"; 
        mainTextArea.setText("You have sought shelter at a nearby cabin...\nYou here a goblin outside....\n\nWhat do you do?"); 
        choice1.setText("Fight the goblin");
        choice2.setText("Run");
    }

    public void fightGoblin()
    {
        /*
            evertime this method is being called, a new JLabel is being created 
            to display the monsters health.. I want it so that it only displays one JLabel
        */ 
        
        position = "fightGoblin"; 
        int goblinHP = 20; 
        goblinHP = goblinHP - 5; 
        playerHealth = playerHealth - 2; 

        healthLabelNumber.setText(""+playerHealth); 
        monsterHealthLabel = new JLabel("Goblin HP");
        monsterHealthLabel.setForeground(Color.white); 
        monsterHealthLabel.setFont(normalFont); 
        playerPanel.add(monsterHealthLabel); 

        monsterHealthNumber = new JLabel(); 
        monsterHealthLabel.setForeground(Color.white);
        monsterHealthLabel.setFont(normalFont); 
        monsterHealthLabel.setText(""+goblinHP); 
        playerPanel.add(monsterHealthNumber); 

        mainTextArea.setText("You hit the goblin for 5 health...\nThe goblin attacks back dealing 2 damage..\n\nWhat do you do?");
        choice1.setText("Attack again");
        choice2.setText("Run");
    }
    public class TitleScreenHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            createGamePlay();
        }
    }

    //class for implementing the choices the user chooses while playing the game. 
    public class ChoiceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String choice = event.getActionCommand(); 

            switch(position)
            {
                //The choices while at the town gate
                case "townGate":

                switch(choice)
                {
                    case "c1": talkToGuard(); break;
                    case "c2":  attackGuard(); break;
                    case "c3": leaveTown();break;   
                }
                break; 
                
                //The choices while talking to the guard
                case "talkGuard":

                switch(choice)
                {
                    case "c1": townGate(); break; 
                }
                break; 

                //The choices after attacking the guard
                case "attackGuard":
                switch(choice)
                {
                    case "c1":talkToGuard();break; 
                    case "c2":townGate();break; 
                }
                break; 

                //The choices for choosing the option to leave the town
                case "leaveTown":
                switch(choice)
                {
                    case "c1": goNorth(); break; 
                    case "c2": townGate(); break;
                    case "c3": break;
                    case "c4": goWest(); break; 
                }
                break; 

                //Choices after going north at the crossroads
                case "north":
                switch(choice)
                {
                    case "c1":leaveTown(); break; 
                }
                break; 
                
                //choices after going west
                case "west":
                switch(choice)
                {
                    case "c1": seekShelter(); break; 
                    case "c2": leaveTown(); break; 
                }
                break; 

                //choices for when shelter is selected
                case "shelter":
                switch(choice)
                {
                    case "c1": fightGoblin(); break; 
                    case "c2": leaveTown(); break;
                }
                break; 
                
                //choices for when fighting the goblin
                case "fightGoblin":
                switch(choice)
                {
                    case "c1": fightGoblin(); break; 
                    case "c2": leaveTown(); break; 
                }
            }

            
        }
    }
}

