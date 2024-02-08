import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel main;
    int screenHeight;
    int screenWidth;

    JPanel topPnl;
    JLabel title;
    ImageIcon icon;

    JPanel displayPnl;
    JTextArea txtArea;
    JScrollPane scroller;

    JPanel controlPnl;
    JButton readBtn;
    JButton quitBtn;

    int i = -1;
    int randIndex;
    Random rnd;


    public FortuneTellerFrame()
    {
        setTitle("The Fortune Teller");
        main = new JPanel();
        main.setLayout(new BorderLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(main);
        main.setBackground(new Color(102, 35, 80));

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenHeight = screenSize.height;
        screenWidth = screenSize.width;
        setSize(3 * (screenWidth / 4), 3 * (screenHeight / 4));

        FortuneTellerLabel();
        main.add(topPnl, BorderLayout.NORTH);

        FortuneDisplay();
        main.add(displayPnl, BorderLayout.CENTER);

        ControlPanel();
        main.add(controlPnl, BorderLayout.SOUTH);
    }
    private void FortuneTellerLabel()
    {
        topPnl = new JPanel();
        topPnl.setBackground(new Color(33, 33, 33));

        icon = new ImageIcon(new ImageIcon("src/Urple_Glass_Ball.gif").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        title = new JLabel("FORTUNE TELLER", icon, JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 48));
        title.setForeground(new Color(204, 70, 160));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.BOTTOM);
        topPnl.add(title);
    }
    private void FortuneDisplay()
    {
        displayPnl = new JPanel();
        displayPnl.setBackground(new Color(33, 33, 33));
        txtArea = new JTextArea(20, 60);
        txtArea.setFont(new Font("SansSerif", Font.ITALIC, 12));
        scroller = new JScrollPane(txtArea);
        displayPnl.add(scroller);
    }
    private void ControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setBackground(new Color(102, 35, 80));
        controlPnl.setLayout(new GridLayout(1, 2));

        ArrayList<String> fortuneList = new ArrayList<>();
        //ChatGPT Generated Fortunes (make up 15 ridiculous fortunes for fortune cookies)
        fortuneList.add("You will find the missing sock that vanished in the laundry abyss.");
        fortuneList.add("You will win a heated debate with a toaster oven.");
        fortuneList.add("Beware of flying spaghetti monsters; they might steal your meatballs.");
        fortuneList.add("Your pet rock will bring you great joy and questionable advice.");
        fortuneList.add("Beware of falling pianos and flying squirrels.");
        fortuneList.add("You will befriend a talking cactus who gives excellent relationship advice.");
        fortuneList.add("A conspiracy of pigeons will nominate you as their spokesperson.");
        fortuneList.add("A troupe of circus clowns will serenade you on your birthday.");
        fortuneList.add("You will discover a portal to a parallel universe behind your bathroom mirror.");
        fortuneList.add("A rubber duck will offer you financial advice; consider it wisely.");
        fortuneList.add("You will stumble upon a treasure map drawn by a dyslexic pirate.");
        fortuneList.add("An army of sentient rubber ducks will enlist you in their war against bath time boredom.");
        //My original fortunes (ChatGPT was playing Mad-Libs with fortunes and it got repetitive)
        fortuneList.add("You will be inducted into the Shadow Wizard Money Gang because you love casting spells.");
        fortuneList.add("You will develop crippling depression.");
        fortuneList.add("You will stumble upon a dog that refuses to take its medication and has a gun.");
        //Bonus fortune
        fortuneList.add("If your friend wants to learn to drive, don't stand in the way.");

        readBtn = new JButton("Read my Fortune!");
        readBtn.addActionListener((ActionEvent ae) ->
        {
            rnd = new Random();
            do
            {
                randIndex = rnd.nextInt(16);
            }while(randIndex == i);
            String fortune = fortuneList.get(randIndex);
            i = randIndex;
            txtArea.append("Your fortune reads: " + fortune + "\n");
        });
        readBtn.setFont(new Font("Monospaced", Font.PLAIN, 16));

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        quitBtn.setFont(new Font("Monospaced", Font.PLAIN, 14));

        controlPnl.add(readBtn);
        controlPnl.add(quitBtn);
    }
}
