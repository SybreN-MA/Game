package Game2;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Game
{
  public static void main(String[] args) throws Exception
  {
//    sound music = new sound();
//    music.soundtest();

    startCredits();
    startAdventure();
  }

////////////ASCII GENERATOR////////////////////////////////////////////////////
      public static final int ART_SIZE_SMALL = 12;
      public static final int ART_SIZE_MEDIUM = 18;
      public static final int ART_SIZE_LARGE = 24;
      public static final int ART_SIZE_HUGE = 32;

      private static final String DEFAULT_ART_SYMBOL = "*";

      public enum ASCIIArtFont
      {
          ART_FONT_DIALOG("Dialog"), ART_FONT_DIALOG_INPUT("DialogInput"),
          ART_FONT_MONO("Monospaced"),ART_FONT_SERIF("Serif"), ART_FONT_SANS_SERIF("SansSerif");

          private String value;

          public String getValue() {
              return value;
          }

          private ASCIIArtFont(String value) {
              this.value = value;
          }
      }


      /**
       * Prints ASCII art for the specified text. For size, you can use predefined sizes or a custom size.
       * Usage - printTextArt("Hi",30,ASCIIArtFont.ART_FONT_SERIF,"@");
       * @param artText
       * @param textHeight - Use a predefined size or a custom type
       * @param fontType - Use one of the available fonts
       * @param artSymbol - Specify the character for printing the ascii art
       * @throws Exception
       */
      private void printTextArt(String artText, int textHeight, ASCIIArtFont fontType, String artSymbol) throws Exception {
          String fontName = fontType.getValue();
          int imageWidth = findImageWidth(textHeight, artText, fontName);

          BufferedImage image = new BufferedImage(imageWidth, textHeight, BufferedImage.TYPE_INT_RGB);
          Graphics g = image.getGraphics();
          Font font = new Font(fontName, Font.BOLD, textHeight);
          g.setFont(font);

          Graphics2D graphics = (Graphics2D) g;
          graphics.drawString(artText, 0, getBaselinePosition(g, font));

          for (int y = 0; y < textHeight; y++) {
              StringBuilder sb = new StringBuilder();
              for (int x = 0; x < imageWidth; x++)
                  sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? artSymbol : " ");
              if (sb.toString().trim().isEmpty())
                  continue;
              System.out.println(sb);
          }
      }

      /**
       * Convenience method for printing ascii text art.
       * Font default - Dialog,  Art symbol default - *
       * @param artText
       * @param textHeight
       * @throws Exception
       */
      private void printTextArt(String artText, int textHeight) throws Exception
      {
          printTextArt(artText, textHeight, ASCIIArtFont.ART_FONT_DIALOG, DEFAULT_ART_SYMBOL);
      }

      /**
       * Using the Current font and current art text find the width of the full image
       * @param textHeight
       * @param artText
       * @param fontName
       * @return
       */
      private int findImageWidth(int textHeight, String artText, String fontName)
      {
          BufferedImage im = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
          Graphics g = im.getGraphics();
          g.setFont(new Font(fontName, Font.BOLD, textHeight));
          return g.getFontMetrics().stringWidth(artText);
      }

      /**
       * Find where the text baseline should be drawn so that the characters are within image
       * @param g
       * @param font
       * @return
       */
      private int getBaselinePosition(Graphics g, Font font)
      {
          FontMetrics metrics = g.getFontMetrics(font);
          int y = metrics.getAscent() - metrics.getDescent();
          return y;
      }
////////////ASCII GENERATOR////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
public static boolean Paladin = false; // 2-handed weapon
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
public static boolean Hunter = false; // bow and daggers
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
public static boolean Mage = false; // Staff and wands
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
public static boolean Warrior = false; // 1-handed and shield
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
public static int direWolf1 = 100;
///////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
public static int PaladinHP = 20;
public static int HolyPower = 20;

public static int MageHP = 20;
public static int Mana = 0;

public static int HunterHP = 20;
public static int Energy = 0;

public static int WarriorHP = 20;
public static int Rage = 0;
///////////////////////////////////////////////////////////////////////////////
  public static void paladinAbilities() throws Exception
  {
    Scanner sca1 = new Scanner(System.in);
    System.out.println("-------------------------------------------------------");
    System.out.println("Your stats:");
    System.out.println("Health = " + PaladinHP);
    System.out.println("");
    System.out.println("Abilities:");
    System.out.println("-1- Flash Heal = 10 Holy Power (+3 HP)");
    System.out.println("-2- Judgement = 15 Holy Power (20 DMG)");
    System.out.println("-3- Templar's Verdict = 30 Holy Power (40 DMG)");
    System.out.println("-4- Consecration = 50 Holy Power (75 DMG)");
    System.out.println("-------------------------------------------------------");
    System.out.println("");
    String abil1 = sca1.nextLine();

     if (direWolf1 <= 0)
      {
        System.out.println("OVERKILL");
        System.out.println("");
        System.out.println("You defeated the Enemy!");
        System.out.println("You continue on your journey");
        System.out.println("");
      }
      else if (abil1.equalsIgnoreCase("1"))
      {
        System.out.println("");
        System.out.println("Your hands glow with holy light!");
        System.out.println("You raise your hand and your wounds are healed by the light.");
        System.out.println("");
        System.out.println("+3 HP");
        System.out.println("");
        PaladinHP += 3;
        System.out.println("");
        paladinAbilities();
      }
      else if (abil1.equals("2"))
      {
        System.out.println("");
        System.out.println("You form a Might hammer out of light.");
        System.out.println("You throw the hammer forward and it smites your enemy.");
        System.out.println("");
        System.out.println("20 DMG");
        System.out.println("");
        direWolf1 -= 20;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
        paladinAbilities();
      }
      else if (abil1.equals("3"))
      {
        System.out.println("");
        System.out.println("You empower your weapon with holy power.");
        System.out.println("You hit the enemy with all your might!");
        System.out.println("");
        System.out.println("40 DMG");
        System.out.println("");
        direWolf1 -= 40;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
        paladinAbilities();
      }
      else if (abil1.equals("4"))
      {
        System.out.println("");
        System.out.println("You raise your weapon, light flies down from the sky.");
        System.out.println("The light engulfs the ground and it burns the ground near the enemy.");
        System.out.println("");
        System.out.println("75 DMG");
        System.out.println("");
        direWolf1 -= 75;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
        paladinAbilities();
      }
   }

  public static void hunterAbilities() throws Exception
  {
    Scanner sca2 = new Scanner(System.in);
    System.out.println("-------------------------------------------------------");
    System.out.println("Your stats:");
    System.out.println("Health = " + HunterHP);
    System.out.println("");
    System.out.println("Abilties:");
    System.out.println("-1- Exhileration = 15 Energy (+5 HP)");
    System.out.println("-2- Aimed shot = 25 Energy (25 DMG)");
    System.out.println("-3- Cobra shot = 35 Energy (45 DMG)");
    System.out.println("-4- Multi shot = 65 Energy (70 DMG)");
    System.out.println("-------------------------------------------------------");
    String abil2 = sca2.nextLine();
      if (direWolf1 <= 1)
      {
        System.out.println("");
        System.out.println("You defeated the dire-wolf!");
        System.out.println("You return to your path and head to the city");
        System.out.println("");
        goldCrestGates();
      }
      else if (abil2.equals("1"))
      {
        System.out.println("");
        System.out.println("You call to the nature for help.");
        System.out.println("A green tinted breeze flies past you and heals your wounds.");
        System.out.println("");
        System.out.println("+5 HP");
        hunterAbilities();
      }
      else if (abil2.equals("2"))
      {
        System.out.println("");
        System.out.println("You swiflty take aim.");
        System.out.println("You hold your breath and shoot.");
        System.out.println("");
        System.out.println("25 DMG");
        System.out.println("");
        direWolf1 -= 25;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
      else if (abil2.equals("3"))
      {
        System.out.println("");
        System.out.println("You ready a poison-coated arrow.");
        System.out.println("The arrow pierces and poisons the enemy.");
        System.out.println("");
        System.out.println("45 DMG");
        System.out.println("");
        direWolf1 -= 45;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
      else if (abil2.equals("4"))
      {
        System.out.println("");
        System.out.println("You take multiple arrows and get ready to launch them.");
        System.out.println("Multiple arrows pierce the enemy.");
        System.out.println("");
        System.out.println("70 DMG");
        System.out.println("");
        direWolf1 -= 70;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
    }

  public static void mageAbilities() throws Exception
  {
    Scanner sca3 = new Scanner(System.in);
    System.out.println("-------------------------------------------------------");
    System.out.println("Your stats:");
    System.out.println("Health = " + MageHP);
    System.out.println("");
    System.out.println("Abilties:");
    System.out.println("-1- Ice block = 10 Mana (+1 HP)");
    System.out.println("-2- Frostbolt = 20 Mana (20 DMG)");
    System.out.println("-3- Fireblast = 35 Mana (45 DMG)");
    System.out.println("-4- Arcane barrage = 55 Mana (65 DMG)");
    System.out.println("-------------------------------------------------------");
    String abil3 = sca3.nextLine();
      if (abil3.equals("1"))
      {
        System.out.println("");
        System.out.println("You start to form ice at your feet.");
        System.out.println("You are engulfed in ice, protected from danger, you heal yourself for a bit.");
        System.out.println("");
        System.out.println("+1 HP");
        System.out.println("");
      }
      if (abil3.equals("2"))
      {
        System.out.println("");
        System.out.println("You form a giant piece of ice in your hand.");
        System.out.println("You eject the Frostbolt from your hand.");
        System.out.println("");
        System.out.println("20 DMG");
        System.out.println("");
        direWolf1 -= 20;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
      if (abil3.equals("3"))
      {
        System.out.println("");
        System.out.println("You make a flaming ball or fire float above your hand.");
        System.out.println("You set the enemy ablaze.");
        System.out.println("");
        System.out.println("45 DMG");
        System.out.println("");
        direWolf1 -= 45;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
      if (abil3.equals("4"))
      {
        System.out.println("");
        System.out.println("You cast multiple Arcane missles.");
        System.out.println("You barrage the enemy with Arcane missles.");
        System.out.println("");
        System.out.println("65 DMG");
        System.out.println("");
        direWolf1 -= 65;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
  }

  public static void warriorAbilities() throws Exception
  {
    Scanner sca4 = new Scanner(System.in);
    System.out.println("-------------------------------------------------------");
    System.out.println("Your stats:");
    System.out.println("Health = " + WarriorHP);
    System.out.println("");
    System.out.println("-1- Victory Rush = 15 Rage (+2 HP | 10 DMG)");
    System.out.println("-2- Slam = 25 Rage (30 DMG)");
    System.out.println("-3- Execute = 40 Rage (45 DMG)");
    System.out.println("-4- Berserker rage 60 Rage (70 DMG)");
    System.out.println("-------------------------------------------------------");
    String abil4 = sca4.nextLine();
      if (abil4.equals("1"))
      {
        System.out.println("");
        System.out.println("You ready your weapons.");
        System.out.println("You charge the enemy and heal yourself.");
        System.out.println("");
        System.out.println("+2 HP");
        System.out.println("");
      }
      if (abil4.equals("2"))
      {
        System.out.println("");
        System.out.println("You raise your shield.");
        System.out.println("You slam down with all your might.");
        System.out.println("");
        System.out.println("30 DMG");
        System.out.println("");
        direWolf1 -= 30;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }
      if (abil4.equals("3"))
      {
        System.out.println("");
        System.out.println("You pull back your sword.");
        System.out.println("You push your sword forward and pierce your enemy's skins.");
        System.out.println("");
        System.out.println("70 DMG");
        System.out.println("");
        direWolf1 -= 70;
        System.out.println("Enemy's HP = " + direWolf1);
        System.out.println("");
      }

  }

  public static void goldCrest() throws Exception
  {
    Scanner goldCrest = new Scanner(System.in);
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("You've now landed yourself in the city.");
    Thread.sleep(2000);
    System.out.println("The city of Goldcrest is  the richest city in all the land.");
    Thread.sleep(2000);
    System.out.println("The home city of the High elves, known for their elegance, itelligence and intuition.");
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("Once you enter the beautiful city of Goldcrest, you awh in wonder of the amazing architecture of the high elves.");
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("You see:");
    System.out.println("-1- Soldier Quarters");
    System.out.println("-2- Tavern");
    System.out.println("*Where do you wish to go?*");
    String goldCrestChoice = goldCrest.nextLine();

      if (goldCrestChoice.equals("1"))
      {
        Thread.sleep(2000);
        System.out.println("You head towards the Tavern.");
        System.out.println("You enter the tavern you see:");
        System.out.println("-1- Stairs");
        System.out.println("-2- Bar");
        System.out.println("*Where do you wish to go?*");
        System.out.println("");
        String  tavernChoice = goldCrest.nextLine();
          if (tavernChoice.equals("1"))
          {

          }
      }
      else if (goldCrestChoice.equals("2"))
      {
        Thread.sleep(2000);
        System.out.println("You head towards the Soldier Quarters");
      }
  }

  public static void goldCrestGates() throws Exception
  {
    Scanner sc3 = new Scanner(System.in);
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("You approach the gates of Goldcrest.");
    System.out.println("You see two guards at their posts next to the gate.");
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("You walk up to the guards.");
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("GUARD:");
    System.out.println("Halt! Who goes there?");
    System.out.println("*What do you wish to say?*");
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("-1- Just a traveler.");
    System.out.println("-2- I am a mighty hero!");
    System.out.println("-3- How about you mind your own business.");
    System.out.println("You say:");
    String gcGuardChoice = sc3.nextLine();
      if (gcGuardChoice.equalsIgnoreCase("1"))
      {
        System.out.println("");
        System.out.println("GUARD:");
        System.out.println("Alright... Just pass through quickly.");
        System.out.println("");
        goldCrest();
      }
      if (gcGuardChoice.equalsIgnoreCase("2"))
      {
        System.out.println("GUARD:");
        System.out.println("Uhm, sure thing... just head in, hero...");
        System.out.println("");
        goldCrest();
      }
      if (gcGuardChoice.equalsIgnoreCase("3"))
      {
        Scanner sc4 = new Scanner(System.in);
        System.out.println("GUARD:");
        System.out.println("How about you bugger off?");
        System.out.println("");
        System.out.println("The guard didn't take to kindly to your attitude.");
        System.out.println("You'll have to find another way in.");
        System.out.println("");
        System.out.println("You see:");
        System.out.println("-1- An old path ");
        System.out.println("-2- A hole");
        System.out.println("-3- The road where you came from");
        System.out.println("");
        String rejectedChoice = sc4.nextLine();
          if (rejectedChoice.equals("1"))
          {
            System.out.println("");
            System.out.println("You look to your left and see an old path.");
            System.out.println("It seems like the city's goverment tried to remove the path for some reason.");
            System.out.println("");
            System.out.println("");
          }
          if (rejectedChoice.equals("2"))
          {
            System.out.println("");
            System.out.println("You see a hole to the quite a bit right of the gate.");
            System.out.println("There are still bricks here, you think the city's goverment would have cleaned it up, or it's recent...");
            System.out.println("");
            System.out.println("You enter the hole, you are now in the city.");
            goldCrest();
          }
       }
    }

  public static void goldCrestRoad() throws Exception
  {
    Scanner goldCrestRoadChoice = new Scanner(System.in);
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("As you walk down the path west, in the direction of Goldcrest");
    System.out.println("In the corner you think you see some movement to your right.");
    System.out.println("*Do you want to investigate? Y/N*");
    System.out.println("");
    System.out.println("");
    String roadmovementChoice = goldCrestRoadChoice.nextLine();
      if (roadmovementChoice.equalsIgnoreCase("y"))
      {
        System.out.println("");
        System.out.println("You walk to your right.");
        System.out.println("");
        Game artGen2 = new Game();
        System.out.println("");
        Thread.sleep(2000);
        System.out.println("A dire wolf appears infront of you!");
        Thread.sleep(2000);
        System.out.println("The wolf looks malnourished, probably hasn't eaten anything for days.");
        Thread.sleep(2000);
        System.out.println("It hears you approaching it, it swiftly turns around.");
        Thread.sleep(2000);
        System.out.println("It prepares to attack you!");
        artGen2.printTextArt("-FIGHT-", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
        System.out.println("");
        System.out.println("What ability do you want to use?");
         if (Paladin = true)
         {
           paladinAbilities();
         }
         else if (Hunter = true)
         {
           hunterAbilities();
         }
         else if (Mage = true)
         {
           mageAbilities();
         }
         else if (Warrior = true)
         {
           warriorAbilities();
         }
        System.out.println("");
        goldCrestGates();
      }

      else if (roadmovementChoice.equalsIgnoreCase("n"))
      {
        System.out.println("");
        Thread.sleep(2000);
        System.out.println("You check around and you don't find anything.");
        Thread.sleep(2000);
        System.out.println("It was probably just your imagination.");
        Thread.sleep(2000);
        System.out.println("A good nights rest will do you good.");
        goldCrestGates();
      }

      else if (roadmovementChoice.equalsIgnoreCase("stop"))
      {
        return;
      }
      else
      {
        System.out.println("");
        System.out.println("ERROR OCCURED");
        System.out.println("SET TO LAST SAVE-POINT");
        System.out.println("");
        startAdventure();
      }
    }

  public static void araMoreGate() throws Exception
    {
      Scanner araMoreGate = new Scanner(System.in);
      System.out.println("");
      Thread.sleep(2000);
      System.out.println("You finally arrived at the gates of AraMore, good job!");
      Thread.sleep(2000);
      System.out.println("You started talking to the guard but he looks really worried!");
      Thread.sleep(2000);
      System.out.println("The guard tells you that there is a succubus that takes people and the people never come back.");
      Thread.sleep(2000);
      System.out.println("The guard asks for your help, are you going to help? Y/N*");
      String helpornohelp = araMoreGate.nextLine();
      if (helpornohelp.equalsIgnoreCase("Y"))
      {
        System.out.println("");
        System.out.println("You told the guard you would help for a few coins.");
        Thread.sleep(2000);
        System.out.println("The guard told you to go to the cave near the city where the succubus lives.");
        Thread.sleep(2000);
        System.out.println("You arrived at the cave and entered it without any hesitation.");
        Thread.sleep(2000);
        System.out.println("You see some dead bodies and rats crawling through the cave, it smells horrible but you keep walking forward.");
        Thread.sleep(2000);
        System.out.println("You see the succubus on her throne. You walk towards her and ask her why she does what she does.");
        Thread.sleep(2000);
        System.out.println("She tells you that she needs them to stay alive, she also tells you that you are different from the others.");
        Thread.sleep(2000);
        System.out.println("She asks you to join her and have a wonderful life. Do you wish to join her? Y/N");
        String joinorkill = araMoreGate.nextLine();
        if (joinorkill.equalsIgnoreCase("Y"))
        {
          Game artGen5 = new Game();
          System.out.println("");
          System.out.println("You told her you want to join.");
          Thread.sleep(2000);
          System.out.println("She tells you to come closer and at that moment she pushes you against her.");
          Thread.sleep(2000);
          System.out.println("You fall asleep onto her but you never woke up...");
          Thread.sleep(2000);
          artGen5.printTextArt("YOU DIED", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
          Thread.sleep(2000);
          System.out.println("");
          startCredits();
            }
            if (joinorkill.equalsIgnoreCase("N"))
            {
              Game artGen6 = new Game();
              System.out.println("");
              System.out.println("You told her you don't want to join.");
              Thread.sleep(2000);
              System.out.println("She looks pretty angry but tries to stay calm.");
              Thread.sleep(2000);
              System.out.println("She starts to attack you after telling you that she is dissapointed.");
              artGen6.printTextArt("-FIGHT-", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
              System.out.println("What ability do you want to use?");
               if (Paladin = true)
               {
                 paladinAbilities();
               }
               else if (Hunter = true)
               {
                 hunterAbilities();
               }
               else if (Mage = true)
               {
                 mageAbilities();
               }
               else if (Warrior = true)
               {
                 warriorAbilities();
               }
              System.out.println("");
              System.out.println("You defeated her! You feel tired but you went to investigate the succubus and got some gold.");
              Thread.sleep(2000);
              System.out.println("You went back to the sign that you saw at the beginning of your adventure...");
              System.out.println("");
              startAdventure();
            }
      }
  if (helpornohelp.equalsIgnoreCase("N"))
      {
        Game artGen7 = new Game();
        System.out.println("You told the guard to bugger off.");
        Thread.sleep(2000);
        System.out.println("The guard warns you for tonight.");
        Thread.sleep(2000);
        System.out.println("You walk into the inn and pay for a room.");
        Thread.sleep(2000);
        System.out.println("After 3 hours, you walk into your room but the succubus is lying on your bed.");
        Thread.sleep(2000);
        System.out.println("She tells you to join her while she slowly takes off her clothing.");
        Thread.sleep(2000);
        System.out.println("She makes some sexy moves so you can't resist and you join her.");
        Thread.sleep(2000);
        System.out.println("After coming super close, you feel something stabbing you through your stomach.");
        Thread.sleep(2000);
        System.out.println("You see it's her pointy tail that is sucking all of your blood.");
        artGen7.printTextArt("YOU DIED", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
      }
    }

  public static void araMoreGateway() throws Exception
    {
      Scanner sc4 = new Scanner(System.in);
      System.out.println("");
      Thread.sleep(2000);
      System.out.println("After 2 hours, you see Aramore in sight!");
      Thread.sleep(2000);
      System.out.println("Do you run for the city or are you going to keep walking? R/W*");
      String runorwalkChoice = sc4.nextLine();
      if (runorwalkChoice.equalsIgnoreCase("R"))
      {
        Game artGen4 = new Game();
        System.out.println("");
        System.out.println("So you began to run but there was a branch and you tripped.");
        artGen4.printTextArt("You Lost 10HP", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
        araMoreGate();
      }
      if (runorwalkChoice.equalsIgnoreCase("W"))
      {
        System.out.println("");
        System.out.println("You decided to take it slowly and just walk.");
        Thread.sleep(2000);
        System.out.println("After some minutes, you spot a homeless man who is walking past you. He looked a bit worried so now you are worried as well.");
        araMoreGate();
      }
    }

  public static void araMoreRoad() throws Exception
  {
    Scanner araMoreRoadChoice = new Scanner(System.in);
     System.out.println("");
     Thread.sleep(2000);
     System.out.println("As you are walking to the north, you can hear some rustling in some bushes...");
     Thread.sleep(2000);
     System.out.println("You are eager to know what is there but will you investigate it? Y/N");
     System.out.println("");
     String roadmovementChoice = araMoreRoadChoice.nextLine();
       if (roadmovementChoice.equalsIgnoreCase("y"))
       {
         System.out.println("");
         System.out.println("You slowly walk towards the bush and you spot a squirrel.");
         Thread.sleep(2000);
         System.out.println("The squirrel looks hungry... Do you feed it? Y/N");
         System.out.println("");
         String feedsquirrel = araMoreRoadChoice.nextLine();
           if (feedsquirrel.equalsIgnoreCase("n"))
           {
             Game artGen3 = new Game();
             System.out.println("");
             System.out.println("The squirrel begins to grow massively and it starts to attack you!");
             artGen3.printTextArt("-FIGHT-", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
               if (Paladin = true)
               {
                 paladinAbilities();
               }
               else if (Hunter = true)
               {
                 hunterAbilities();
               }
               else if (Mage = true)
               {
                 mageAbilities();
               }
               else if (Warrior = true)
               {
                 warriorAbilities();
               }
              System.out.println("");
              araMoreGateway();
           }
           if (feedsquirrel.equalsIgnoreCase("y"))
           {
             System.out.println("");
             System.out.println("The squirrel quickly grabs the few peanuts you gave him and runs away...");
             System.out.println("After seeing the squirrel leave, you walk further towards Aramore.");
             araMoreGateway();
           }

         }
         if (roadmovementChoice.equalsIgnoreCase("n"))
         {
          System.out.println("");
          System.out.println("You quickly run away because you are too scared to see what's in the bush...");
          Thread.sleep(2000);
          System.out.println("As you run away you see a squirrel come out of the bush as you look behind you.");
          araMoreGateway();
       }
  }

  public static void  rivianRoad() throws Exception
  {

  }

  public static void returnToStart() throws Exception
  {
    System.out.println("======================================================");
    Thread.sleep(2000);
    System.out.println("You return to the sign you started at.");
    Thread.sleep(2000);
    System.out.println("You decide to head in the direction of Goldcrest now.");
    System.out.println("");
    Thread.sleep(2000);
    System.out.println("You head west...");
    System.out.println("======================================================");
    goldCrestRoad();
  }

  public static void startAdventure() throws Exception
  {
    Scanner sc2 = new Scanner(System.in);
    System.out.println("");
    System.out.println("======================================================");
    System.out.println("The hero's journey starts in a world filled with mythical monsters and beasts.");
    Thread.sleep(2000);
    System.out.println("Your journey starts in a forest... A slight breeze in the air, Gryphons flying, Dwarves mining and Elves lounging");
    Thread.sleep(2000);
    System.out.println("In this world, everything is for the taking.");
    Thread.sleep(2000);
    System.out.println("As you walk down the path you come by a crossroads.");
    Thread.sleep(2000);
    System.out.println("You see a sign, on the sign you read:");
    Thread.sleep(2000);
    System.out.println("Goldcrest -West- | Aramore -North- | Rivian -East- (IN PROGRESS)");
    System.out.println("======================================================");
    System.out.println("*Which direction do you wish to go?*");
    System.out.println("");
    String beginRoadChoice = sc2.nextLine();
    System.out.println("");
      if (beginRoadChoice.equalsIgnoreCase("west"))
      {
        System.out.println("");
        System.out.println("You head west...");
        goldCrestRoad();
      }
      else if (beginRoadChoice.equalsIgnoreCase("north"))
      {
        System.out.println("");
        System.out.println("You head north...");
         araMoreRoad();
      }
      else if (beginRoadChoice.equalsIgnoreCase("east"))
      {
        System.out.println("");
        System.out.println("You head east...");
      }
      else if (beginRoadChoice.equalsIgnoreCase("stop"))
      {
        return;
      }
      else
      {
        System.out.println("");
        System.out.println("ERROR OCCURED");
        System.out.println("SET TO LAST SAVE-POINT");
        System.out.println("");
        startCredits();
      }
    }


  public static void startCredits() throws Exception
  {
    Game artGen = new Game();
    Scanner start = new Scanner(System.in);
    System.out.println("------------------------------------------");
    artGen.printTextArt("Welcome to our game!", Game.ART_SIZE_SMALL, ASCIIArtFont.ART_FONT_MONO,"@");
    System.out.println(" ");
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("Story and Gameplay by: Levi Kramer and Zack Wijngaard");
    System.out.println("Sound by: Alex Janson");
    System.out.println("------------------------------------------");
    System.out.println("------------------------------------------");
    System.out.println("Here are some commands you can always use:");
    System.out.println("'Inventory' (Show your inventory)");
    System.out.println("'Stats' (Show your character's stats)");
    System.out.println("'Back' (Return to the last save-point)");
    System.out.println("------------------------------------------");
    System.out.println("Enter anything to continue");
    System.out.println("");
    String startcontinue = start.nextLine();
      if (startcontinue.equalsIgnoreCase("1"))
      {
        nameAndClass();
      }
      else
      {
        nameAndClass();
      }
  }

  public static void nameAndClass() throws Exception
  {
    Scanner sc = new Scanner(System.in);
    System.out.println(" ");
    System.out.println("Let me tell you a story about a hero named...");
    System.out.println("");
    String beginname = sc.nextLine();
    System.out.println("");
    System.out.println(beginname + " was a very powerful...");
    System.out.println("-Paladin- -Hunter- -Mage- -Warrior-");
    System.out.println("");
    String classchoice = sc.nextLine();
      if (classchoice.equalsIgnoreCase("paladin"))
      {
        Paladin = true;
        PaladinHP = 20;
        HolyPower = 100;
      }
      else if (classchoice.equalsIgnoreCase("hunter"))
      {
        Hunter = true;
        HunterHP = 16;
        Energy = 100;
      }
      else if (classchoice.equalsIgnoreCase("mage"))
      {
        Mage = true;
        MageHP = 14;
        Mana = 100;
      }
      else if (classchoice.equalsIgnoreCase("warrior"))
      {
        Warrior = true;
        WarriorHP = 18;
        Rage = 100;
      }
      else if (classchoice.equalsIgnoreCase("stop"))
      {
        return;
      }
      else
      {
        System.out.println("");
        System.out.println("ERROR OCCURED");
        System.out.println("SET TO LAST SAVE-POINT");
        System.out.println("");
        startCredits();
      }
  }


} //public class
