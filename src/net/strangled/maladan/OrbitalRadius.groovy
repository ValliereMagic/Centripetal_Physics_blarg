package net.strangled.maladan

/**
 * MaladaN(R)
 */
class OrbitalRadius {
    static execute(LinkedList<String> info) {
        def cMass = null
        def period = null
        def aC = null
        def velocity = null
        def frequency = null
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i) == '-cm') {
                cMass = info.get(i + 1)
            } else if (info.get(i) == '-p') {
                period = info.get(i + 1)
            } else if (info.get(i) == '-cacc') {
                aC = info.get(i + 1)
            } else if (info.get(i) == '-v') {
                velocity = info.get(i + 1)
            } else if (info.get(i) == '-fr') {
                frequency = info.get(i + 1)
            }
        }
        if (period && !cMass && !aC && !velocity && !frequency) {
            return periodOnly(Double.valueOf(period))
        } else if (period && velocity && !cMass && !aC && !frequency) {
            return periodAndVelocity(Double.valueOf(period), Double.valueOf(velocity))
        } else if (velocity && frequency && !period && !cMass && !aC) {
            return frequencyAndVelocity(Double.valueOf(frequency), Double.valueOf(velocity))
        } else if (velocity && aC && !period && !frequency && !cMass) {
            return aCAndVelocity(Double.valueOf(aC), Double.valueOf(velocity))
        } else if (velocity && !aC && !period && !frequency && !cMass) {
            return velocityOnly(Double.valueOf(velocity))
        } else if (velocity && !aC && !period && !frequency && cMass) {
            return velocityAndCentralMass(Double.valueOf(velocity), Double.valueOf(cMass))
        } else if (!velocity && !aC && period && !frequency && cMass) {
            return periodAndCentralMass(Double.valueOf(period), Double.valueOf(cMass))
        }
        else {
            return "Either not enough data supplied, or parameters not supported."
        }
    }

    static periodOnly(double period) {
        earthAssumption()
        return answerFormatter(Math.cbrt((Main.gravityConstant * Main.cMassOfEarth * ((period)**2) / (4 * (Math.pow(Math.PI, 2))))))
    }
    static periodAndVelocity(double period, double velocity) {
        return answerFormatter(velocity * period) / (2 * (Math.PI))
    }
    static frequencyAndVelocity(double frequency, double velocity) {
        return answerFormatter(velocity * (1 / frequency) / (2 * (Math.PI)))
    }
    static aCAndVelocity(double aC, double velocity) {
        return answerFormatter((velocity**2 / aC))
    }
    static velocityOnly(double velocity) {
        earthAssumption()
        return answerFormatter(Math.sqrt((Main.gravityConstant * Main.cMassOfEarth) / (velocity)**2))
    }
    static velocityAndCentralMass(double velocity, double cMass) {
        return answerFormatter(Math.sqrt((Main.gravityConstant * cMass) / (velocity)**2))
    }
    static periodAndCentralMass(double period, double cMass) {
        return answerFormatter(Math.cbrt((Main.gravityConstant * cMass * ((period)**2) / (4 * (Math.pow(Math.PI, 2))))))
    }

    static answerFormatter(double answer) {
        return "The orbital radius is: " + answer + " meters."
    }
    static earthAssumption() {
        println('Assuming earth as object being orbited')
    }
}
