import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl;
    JPanel iconPnl;
    JPanel displayPnl;
    JPanel controlPnl;

    JLabel iconLbl;
    ImageIcon FTIcon;

    JScrollPane scroller;
    JTextArea fortuneTA;
    JButton quitBtn;
    JButton fortuneBtn;

    ArrayList<String> fortuneList;

    Random rand;
    int pickedFortune;
    int lastFortune = -1;


    public FortuneTellerFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());



        createIconPanel();
        createDisplayPanel();
        createControlPanel();
        add(mainPnl);
        mainPnl.add(controlPnl,BorderLayout.SOUTH);
        mainPnl.add(iconPnl,BorderLayout.NORTH);
        mainPnl.add(displayPnl,BorderLayout.CENTER);


        this.add(mainPnl);

        fortuneList = new ArrayList<>();

        fortuneList.add("You will die tomorrow.");
        fortuneList.add("You will win the lottery.");
        fortuneList.add("You will oversleep your alarm tomorrow.");
        fortuneList.add("You will pass your next exam.");
        fortuneList.add("You will fail this class.");
        fortuneList.add("You will find a dollar on the ground.");
        fortuneList.add("Someone will be kind to you today.");
        fortuneList.add("Someone will be mean to you today.");
        fortuneList.add("You will get free food today.");
        fortuneList.add("You will slip and fall on the stairs.");
        fortuneList.add("You will meet a new friend today.");
        fortuneList.add("You will find a penny on the ground.");
        fortuneList.add("You will be late to class today.");
        rand = new Random();

        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fortuneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               pickedFortune= rand.nextInt(13);
               while(pickedFortune == lastFortune){
                   pickedFortune= rand.nextInt(13);
               }
                lastFortune = pickedFortune;
               fortuneTA.append(fortuneList.get(pickedFortune));
               fortuneTA.append("\n");


            }
        });

    }

    private void createControlPanel() {

        fortuneBtn = new JButton("Read My Fortune!");
        quitBtn = new JButton("Quit");
        controlPnl = new JPanel();

        Font f = new Font("Serif", Font.BOLD, 15);
        controlPnl.setFont(f);

        controlPnl.setBorder(BorderFactory.createEmptyBorder());
        controlPnl.add(fortuneBtn,BorderLayout.WEST);
        controlPnl.add(quitBtn,BorderLayout.EAST);

        mainPnl.add(controlPnl,BorderLayout.CENTER);
        controlPnl.setVisible(true);
        add(controlPnl);

    }

    private void createDisplayPanel() {

        displayPnl = new JPanel();
        fortuneTA = new JTextArea(5,30);
        scroller = new JScrollPane(fortuneTA);

        Font f = new Font("Comic Sans MS", Font.BOLD, 15);
        fortuneTA.setFont(f);
        displayPnl.setBorder(BorderFactory.createEmptyBorder());
        displayPnl.add(scroller,BorderLayout.CENTER);


    }

    private void createIconPanel() {
        iconPnl = new JPanel();
        FTIcon = new ImageIcon("fortuneTeller.png");


        Image image = FTIcon.getImage();
        image = image.getScaledInstance(120,120, Image.SCALE_SMOOTH);
        FTIcon = new ImageIcon(image);
        iconLbl = new JLabel(FTIcon);
        Font f = new Font("Serif", Font.ITALIC, 36);
        iconLbl.setFont(f);
        iconPnl.setBorder(BorderFactory.createEmptyBorder());
        iconLbl.setIcon(FTIcon);
        iconLbl.setText("Fortune Teller");
        iconPnl.add(iconLbl);

        mainPnl.add(iconPnl,BorderLayout.NORTH);
        iconPnl.setVisible(true);
        add(iconPnl);


    }
}
