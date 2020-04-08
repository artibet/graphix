package xmaze;

import java.awt.*;
import javax.swing.*;


/**
 *
 * @author Νίκος Κανάργιας, φοιτητής ΕΑΠ, ΠΛΗ31 2012-13
 * E-mail: nkana@tee.gr
 * @version 4.0
 * 
 * Το πρόγραμμα λύνει και οπτικοποιεί το πρόβλημα του σχεδιασμού κίνησης ρομπότ
 * (robot motion planning) υλοποιώντας λέξη προς λέξη τους αλγόριθμους
 * DFS, BFS και A*, όπως αυτοί περιγράφονται στο βιβλίο
 * "Τεχνητή Νοημοσύνη και Έμπειρα Συστήματα" της Ε. Κεραυνού, ΠΑΤΡΑ 2000
 * καθώς και τον αλγόριθμο της άπληστης αναζήτησης, σαν ειδική περίπτωση του Α*.
 * 
 * Το πρόγραμμα παρέχει εναλλακτικά και την δυνατότητα τερματισμού των αλγόριθμων
 * όταν ο στόχος βρεθεί στις κλειστές καταστάσεις.
 * 
 * Το πρόγραμμα ακόμη υλοποιεί τον αλγόριθμο του Dijkstra όπως ακριβώς αυτός 
 * περιγράφεται το σχετικό άρθρο της Wikipedia.
 * http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 * 
 * Γίνεται ολοφάνερη η υπεροχή των αλγόριθμων Α* και Dijkstra απέναντι στους άλλους τρεις.
 * 
 * Ο χρήστης μπορεί μεταβάλει τα πλήθη των γραμμών και των στηλών του πλέγματος.
 * 
 * Ο χρήστης μπορεί να προσθέσει όσα εμπόδια θέλει, όπως θα σχεδίαζε ελεύθερες
 * καμπύλες με ένα σχεδιαστικό πρόγραμμα.
 * 
 * Αφαίρεση μεμονωμένων εμποδίων γίνεται κάνοντας κλικ επάνω τους.
 * 
 * Η θέση του ρομπότ ή/και του στόχου μπορεί να αλλάξει με σύρσιμο με το ποντίκι.
 * 
 * Μεταπήδηση από την αναζήτηση "Βήμα-Βήμα" στην αναζήτηση με "Κίνηση" και αντίστροφα
 * γίνεται πιέζοντας το αντίστοιχο κουμπί, ακόμη και όταν η αναζήτηση είναι σε εξέλιξη.
 * 
 * Η ταχύτητα μιας αναζήτησης με κίνηση μπορεί να μεταβληθεί, ακόμη και αν η
 * αναζήτηση είναι σε εξέλιξη, αρκεί να τοποθετηθεί ο  slider "Ταχύτητα" στην νέα
 * επιθυμητή θέση και στη συνέχεια πιεστεί το κουμπί "Κίνηση".
 * 
 * Η εφαρμογή θεωρεί ότι το ίδιο το ρομπότ έχει κάποιον όγκο. Συνεπώς δεν μπορεί
 * να κινηθεί διαγώνια προς ελεύθερο κελί ανάμεσα από δύο εμπόδια που εφάπτονται
 * σε μία κορυφή τους.
 *
 * Δεν είναι δυνατή η αλλαγή των θέσεων εμποδίων, ρομπότ και στόχου όπως και του
 * είδους του αλγόριθμου, ενόσω η αναζήτηση είναι σε εξέλιξη.
 * 
 * Συνιστάται η αποφυγή σχεδίασης βελών προς προκατόχους σε πλέγματα μεγάλης διάστασης.
 */

public class Maze40 {

    public static JFrame mazeFrame;  // Η κύρια φόρμα του προγράμματος
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int width  = 693;
        int height = 545;
        mazeFrame = new JFrame("Maze 4.0");
        mazeFrame.setContentPane(new MazePanel(width,height));
        mazeFrame.pack();
        mazeFrame.setResizable(false);

        // τοποθετούμε τη φόρμα στο κέντρο της οθόνης
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenWidth = screenSize.getWidth();
        double ScreenHeight = screenSize.getHeight();
        int x = ((int)screenWidth-width)/2;
        int y = ((int)ScreenHeight-height)/2;

        mazeFrame.setLocation(x,y);
        mazeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mazeFrame.setVisible(true);
    } // end main()
    
} // end class Maze