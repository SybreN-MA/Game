package Game2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.util.Random;

public class GameFX extends Application
{
    private Pane myPane = new Pane();

    private Sound sound = new Sound();

    Text t1 = new Text();
    Text t2 = new Text();
    Text at1 = new Text();
    Text at2 = new Text();
    Text at3 = new Text();
    Text EnemyHP = new Text();
    Text YourHP = new Text();
    Text EnemyAttack = new Text();

    boolean mage = false, warrior = false;
    int hp, dmg, ehp, edmg;
    String Class;

    String ClassAbil1;
    String ClassAbil2;
    String ClassAbil3;
    String pp1;
    String pp2;
    String pp3;

    StackPane sp2;
    StackPane sp3;
    StackPane sp4;
    StackPane sp5;
    StackPane img2 = new StackPane();
    StackPane img3 = new StackPane();
    StackPane abils1 = new StackPane();
    StackPane EHP = new StackPane();
    StackPane YHP = new StackPane();

    VBox vb1 = new VBox();
    VBox vb2 = new VBox();
    VBox vb3 = new VBox();

    HBox hb2 = new HBox();
    HBox imgs = new HBox();

    Image imgWarrior = new Image(getClass().getResource("/Game2/Images/Warrior.jpg").toExternalForm());
    Image imgMage = new Image(getClass().getResource("/Game2/Images/Mage.jpg").toExternalForm());
    Image imgSC = new Image(getClass().getResource("/Game2/Images/Select_Class.png").toExternalForm());
    Image imgBG = new Image(getClass().getResource("/Game2/Images/bg.jpg").toExternalForm());
    Image imgDung1 = new Image(getClass().getResource("/Game2/Images/dung1.png").toExternalForm());
    Image imgDungO = new Image(getClass().getResource("/Game2/Images/outside.jpg").toExternalForm());
    Image imgClass;
    Image imgNec = new Image(getClass().getResource("/Game2/Images/necromancer.png").toExternalForm());

    ImageView imgViewClass;
    ImageView imgViewWarrior;
    ImageView imgViewMage;
    ImageView imgViewSC;
    ImageView imgViewBG;
    ImageView imgViewDung1;
    ImageView imgViewOutside;
    ImageView imgViewNec;

    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button fbtn1 = new Button();
    Button fbtn2 = new Button();
    Button fbtn3 = new Button();


    VBox vButtons = new VBox();

    public static void main(String[] args)
    {
        String[] Enemy = new String[10];
        Enemy[0] = "Skeleton";
        Enemy[1] = "Goblin";
        Enemy[2] = "Orc";
        Enemy[3] = "Werewolf";
        Enemy[4] = "Abomination";
        Enemy[5] = "Geist";
        Enemy[6] = "Manticore";
        Enemy[7] = "Hydra";
        Enemy[8] = "Necromancer";
        Enemy[9] = "Drake";

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception, InterruptedException
    {
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);

        primaryStage.setTitle("The Majestic World of Mastogoth");
        Image img = new Image(getClass().getResource("startscreen.jpg").toExternalForm());
        ImageView imgView;
        imgView = new ImageView(img);

        Button button1 = new Button();
        button1.setText("Class Selection");

        HBox hb1 = new HBox();
        hb1.getChildren().add(button1);

        StackPane sp1 = new StackPane();
        sp1.getChildren().addAll(imgView, hb1);

        HBox root = new HBox();
        root.getChildren().add(sp1);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(imgView, button1);
        Scene myScene = new Scene(layout, 1920, 1080);
        primaryStage.setScene(myScene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        button1.setOnAction(e ->{

            layout.getChildren().removeAll(imgView, button1);
            imgWarrior = new Image(getClass().getResource("/Game2/Images/Warrior.jpg").toExternalForm());
            imgMage = new Image(getClass().getResource("/Game2/Images/Mage.jpg").toExternalForm());
            imgSC = new Image(getClass().getResource("/Game2/Images/Select_Class.png").toExternalForm());
            imgBG = new Image(getClass().getResource("/Game2/Images/bg.jpg").toExternalForm());

            imgViewWarrior = new ImageView(imgWarrior);
            imgViewMage = new ImageView(imgMage);
            imgViewSC = new ImageView(imgSC);
            imgViewBG = new ImageView(imgBG);

            imgViewWarrior.setScaleX(1);
            imgViewWarrior.setScaleY(1);
            imgViewWarrior.setX(0);
            imgViewWarrior.setY(0);

            imgViewSC.setScaleX(1);
            imgViewSC.setScaleY(1);
            imgViewSC.setX(400);
            imgViewSC.setY(400);

            imgViewMage.setScaleX(1);
            imgViewMage.setScaleY(1);
            imgViewMage.setX(200);
            imgViewMage.setY(200);


            imgs = new HBox();
            imgs.getChildren().addAll(imgViewWarrior, imgViewSC, imgViewMage);
            imgs.setPadding(new Insets(80, 20, 10, 20));

            sp2 = new StackPane();
            sp2.setPadding(new Insets(0, 20, 10, 0));
            sp2.getChildren().addAll(imgViewBG);

            btn2.setText("Warrior");
            btn2.setTranslateX(325);
            btn2.setTranslateY(10);


            btn3.setText("Mage");
            btn3.setTranslateX(1400);
            btn3.setTranslateY(10);


            vButtons = new VBox();
            vButtons.getChildren().addAll(btn2, btn3);



            myPane.getChildren().addAll(sp2, imgs, vButtons);


            Scene myScene2 = new Scene(myPane, 1920, 1080);
            primaryStage.setScene(myScene2);
            primaryStage.setFullScreen(true);
            primaryStage.show();

            btn2.setOnAction(e2 -> {
                warrior = true;
                Class = "Warrior";
                ClassAbil1 = "Slash";
                ClassAbil2 = "Charge";
                ClassAbil3 = "Bladestorm";
                imgClass = new Image(getClass().getResource("/Game2/Images/Warrior.jpg").toExternalForm());
                imgViewClass = new ImageView(imgClass);

                System.out.println("Test Warrior");
                imgs.getChildren().removeAll(imgViewSC, imgViewMage, imgViewWarrior, imgViewBG);
                imgViewOutside = new ImageView(imgDungO);

                try
                {
                    Thread.sleep(400);
                } catch ( InterruptedException inex) {inex.printStackTrace();
                }

                t1 = new Text();
                t2 = new Text();
                t1.setText("You as a " + Class + " Now have the abilities:");
                t2.setText(ClassAbil1 + ", " + ClassAbil2 + " and " + ClassAbil3);
                System.out.println(Class);
                System.out.println(ClassAbil1 + " " + ClassAbil2 + " " + ClassAbil3);

                t1.setFont(Font.font ("Broadway", 40));
                t1.setFill(Color.WHITE);

                t2.setFont(Font.font ("Broadway", 40));
                t2.setFill(Color.LIGHTGOLDENRODYELLOW);

                t1.setTextAlignment(TextAlignment.CENTER);

                vb2 = new VBox();
                vb2.getChildren().addAll(t1, t2);

                sp5 = new StackPane();
                sp5.getChildren().addAll(vb2);

                sp5.setAlignment(Pos.CENTER);
                vb2.setAlignment(Pos.CENTER);

                btn4 = new Button("Enter the Dungeon");

                hb2 = new HBox();
                hb2.getChildren().add(btn4);

                hb2.setPadding(new Insets(600, 0, 0, 900));

                sp3 = new StackPane();
                sp3.getChildren().addAll(imgViewOutside, sp5, hb2);

                Scene myScene3 = new Scene(sp3, 800,800);
                primaryStage.setScene(myScene3);
                primaryStage.setFullScreen(true);
                primaryStage.show();

                btn4.setOnAction(e4 -> {
                    try
                    {
                        Thread.sleep(500);
                    } catch ( InterruptedException inex2) {inex2.printStackTrace();
                    }

                    sp3.getChildren().removeAll(imgViewOutside, vb1, hb2);

                    try{
                        verder(primaryStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            });

            btn3.setOnAction(e3 -> {
                mage = true;
                Class = "Mage";
                ClassAbil1 = "Frostbolt";
                ClassAbil2 = "Pyroblast";
                ClassAbil3 = "Arcane missles";
                imgClass = new Image(getClass().getResource("/Game2/Images/Mage.jpg").toExternalForm());
                imgViewClass = new ImageView(imgClass);

                System.out.println("Test Mage");
                imgs.getChildren().removeAll(imgViewSC, imgViewMage, imgViewWarrior, imgViewBG);
                imgViewOutside = new ImageView(imgDungO);

                try
                {
                    Thread.sleep(400);
                } catch ( InterruptedException inex) {inex.printStackTrace();
                }


                t1 = new Text();
                t2 = new Text();
                t1.setText("You as a " + Class + " Now have the abilities:");
                t2.setText(ClassAbil1 + ", " + ClassAbil2 + " and " + ClassAbil3);
                System.out.println(Class);
                System.out.println(ClassAbil1 + " " + ClassAbil2 + " " + ClassAbil3);

                t1.setFont(Font.font ("Roboto", 40));
                t1.setFill(Color.WHITE);

                t2.setFont(Font.font ("Roboto", 40));
                t2.setFill(Color.LIGHTGOLDENRODYELLOW);

                t1.setTextAlignment(TextAlignment.CENTER);

                vb2 = new VBox();
                vb2.getChildren().addAll(t1, t2);

                sp5 = new StackPane();
                sp5.getChildren().addAll(vb2);

                sp5.setAlignment(Pos.CENTER);
                vb2.setAlignment(Pos.CENTER);

                btn4 = new Button("Enter the Dungeon");

                hb2 = new HBox();
                hb2.getChildren().add(btn4);

                hb2.setPadding(new Insets(600, 0, 0, 900));

                sp3 = new StackPane();
                sp3.getChildren().addAll(imgViewOutside, sp5, hb2);

                Scene myScene3 = new Scene(sp3, 800,800);
                primaryStage.setScene(myScene3);
                primaryStage.setFullScreen(true);
                primaryStage.show();

                btn4.setOnAction(e4 -> {
                    try
                    {
                        Thread.sleep(500);
                    } catch ( InterruptedException inex2) {inex2.printStackTrace();
                    }

                    sp3.getChildren().removeAll(imgViewOutside, vb1, hb2);

                    try{
                        verder(primaryStage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

            });
        });
    }

    public void verder(Stage primaryStage) throws Exception
    {
        imgDung1 = new Image(getClass().getResource("/Game2/Images/dung1.png").toExternalForm());
        imgViewDung1 = new ImageView(imgDung1);

        imgNec = new Image(getClass().getResource("/Game2/Images/necromancer.png").toExternalForm());
        imgViewNec = new ImageView(imgNec);

        img2 = new StackPane();
        img2.getChildren().addAll(imgViewClass);

        img3 = new StackPane();
        img3.getChildren().addAll(imgViewNec);

        img2.setAlignment(Pos.CENTER_LEFT);
        img3.setAlignment(Pos.CENTER_RIGHT);

        fbtn1.setText(ClassAbil1);
        fbtn2.setText(ClassAbil2);
        fbtn3.setText(ClassAbil3);

        abils1 = new StackPane();

        ehp = 100000;
        hp = 100000;

        EnemyHP.setText("Enemy's HP: " + ehp);
        EnemyHP.setFont(Font.font ("Roboto", 40));
        EnemyHP.setFill(Color.RED);

        YourHP.setText("Your HP: " + hp);
        YourHP.setFont(Font.font("Roboto", 40));
        YourHP.setFill(Color.GREEN);

        EHP.getChildren().add(EnemyHP);
        EHP.setAlignment(Pos.TOP_RIGHT);

        YHP.getChildren().add(YourHP);
        YHP.setAlignment(Pos.TOP_LEFT);

        fbtn1.setOnAction(e1 -> {
            abils1.getChildren().removeAll(at1, at2, at3);
            try
            {
                Thread.sleep(500);
            } catch ( InterruptedException inex2) {inex2.printStackTrace();
            }
            System.out.println("Test");
            if(mage)
            {
                pp1 = "Frostbolt - 10 DMG";
            }
            if(warrior)
            {
                pp1 = "Slash - 10 DMG";
//                try
//                {
//                    sound.Music("Sounds/slash");
//                } catch ( LineUnavailableException|IOException|UnsupportedAudioFileException exc)
//                {
//                    exc.printStackTrace();
//                }
            }
            dmg = 30;
            ehp = ehp - dmg;
            EnemyHP.setText("Enemy's HP: " + ehp);

            double rn = Math.random();
            double x = rn * 50;

            int r = (int) x + 1;

            edmg = r;
            hp = hp - edmg;
            System.out.println(edmg);

            YourHP.setText("Your HP: " + hp);

            EnemyAttack.setText("The enemy hits you and deals " + edmg + " DMG!");

            at1 = new Text();
            at1.setText("You use " + pp1  + "!");
            at1.setFont(Font.font("Roboto", 40));
            at1.setFill(Color.GREEN);

            abils1.getChildren().add(at1);

            EHP.getChildren().remove(EnemyHP);
            EHP.getChildren().add(EnemyHP);
        });
        fbtn2.setOnAction(e2 -> {
            abils1.getChildren().removeAll(at1, at2, at3);
            try
            {
                Thread.sleep(500);
            } catch ( InterruptedException inex2) {inex2.printStackTrace();
            }
            System.out.println("Test");
            if(mage)
            {
                pp2 = "Pyroblast - 25 DMG";
            }
            if(warrior)
            {
                pp2 = "Charge - 25 DMG";
            }
            dmg = 55;
            ehp = ehp - dmg;
            EnemyHP.setText("Enemy's HP: " + ehp);

            double rn = Math.random();
            double x = rn * 50;

            int r = (int) x + 1;

            edmg = r;
            hp = hp - edmg;
            System.out.println(edmg);

            at2 = new Text();
            at2.setText("You use " + pp2  + "!");
            at2.setFont(Font.font("Roboto", 40));
            at2.setFill(Color.GREEN);

            abils1.getChildren().add(at2);

            EHP.getChildren().remove(EnemyHP);
            EHP.getChildren().add(EnemyHP);
        });
        fbtn3.setOnAction(e3 -> {
            abils1.getChildren().removeAll(at1, at2, at3);
            try
            {
                Thread.sleep(500);
            } catch ( InterruptedException inex2) {inex2.printStackTrace();
            }
            System.out.println("Test");
            if(mage)
            {
                pp3 = "Arcane missles - 55 DMG";
            }
            if(warrior)
            {
                pp3 = "Bladestorm - 55 DMG";
            }
            dmg = 110;
            ehp = ehp - dmg;
            EnemyHP.setText("Enemy's HP: " + ehp);

            double rn = Math.random();
            double x = rn * 50;

            int r = (int) x + 1;

            edmg = r;
            hp = hp - edmg;
            System.out.println(edmg);

            at3 = new Text();
            at3.setText("You use " + pp3  + "!");
            at3.setFont(Font.font("Roboto", 40));
            at3.setFill(Color.GREEN);

            abils1.getChildren().add(at3);

            EHP.getChildren().remove(EnemyHP);
            EHP.getChildren().add(EnemyHP);
        });

        vb3 = new VBox();
        vb3.getChildren().addAll(fbtn1, fbtn2, fbtn3);
        vb3.setSpacing(10);
        vb3.setPadding(new Insets(250, 100, 100, 0));

        sp3.getChildren().addAll(imgViewDung1, img2, img3, abils1, EHP, YHP, vb3);

    }

    public void EnemyAttack()
    {

    }
}
