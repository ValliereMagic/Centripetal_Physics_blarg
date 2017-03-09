package net.strangled.maladan

/**
 * MaladaN (R)
 */
class Documentation {
    static void printInstructions() {
        print("This is the MaladaN Centripetal Physics calculator. Instructions follow. \n" +
                "=======================================================================\n" +
                "Masses must be submitted in meters.\n" +
                "Velocities must be submitted in meters per second.\n" +
                "Periods must be submitted in seconds.\n" +
                "Centripetal Accelerations must be submitted in meters per second squared.\n" +
                "Frequency must be submitted in hertz\n" +
                "=========================================================================\n" +
                "   To get Help using the program: use --help or -h \n" +
                "===========================================================\n" +
                "   To calculate orbital radius use --orbital-radius, or -or \n" +
                "   Note: when only velocity or only period are used, the mass of\n" +
                "   earth will be assumed for the central object's mass.\n" +
                "       To specify the central object's mass use -cm \n" +
                "       To specify period use -p \n" +
                "       To specify centripetal acceleration use -cacc\n" +
                "       To specify frequency use -fr\n" +
                "       To specify velocity use -v\n" +
                "================================================================================\n" +
                "   To calculate centripetal acceleration use --centripetal-acceleration or -cacc \n" +
                "       To specify the orbiting object's mass use -orm \n" +
                "       To specify the force of gravity use -fG\n" +
                "       To specify the orbital radius use -or\n" +
                "=====================================================================================\n" +
                "   To calculate the mass of an object being orbited, use --calc-mass-central or -cMass \n" +
                "       To specify velocity use -v\n" +
                "       To specify orbital radius use -or\n" +
                "       To specify period use -p\n" +
                "       To specify frequency use -fr\n" +
                "       To specify centripetal acceleration use -cacc\n")
    }
}
