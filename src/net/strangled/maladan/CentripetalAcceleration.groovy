package net.strangled.maladan

/**
 * MaladaN (R)
 */
class CentripetalAcceleration {
    static execute(LinkedList<String> info) {
        Options options = new Options(info)
        if (options.getSize() == 2) {
            if (options.getVelocity() && options.getOrbitalRadius()) {
                velocityAndRadius(options.getVelocity(), options.getOrbitalRadius())
            } else if (options.getForceCentripetal() && options.getOrMass()) {
                massAndForceCentripetal(options.getOrMass(), options.getForceCentripetal())
            } else if (options.getOrbitalRadius() && options.getPeriod()) {
                radiusAndPeriod(options.getOrbitalRadius(), options.getPeriod())
            } else if (options.getFrequency() && options.getOrbitalRadius()) {
                frequencyAndRadius(options.getFrequency(), options.getOrbitalRadius())
            } else {
                return Main.errorMessage
            }
        } else if (options.getSize() == 1) {
            if (options.getOrbitalRadius()) {
                radiusOnly(options.getOrbitalRadius())
            } else {
                return Main.errorMessage
            }
        } else {
            return Main.errorMessage
        }
    }

    static velocityAndRadius(double velocity, double radius) {
        return answerFormatter((velocity**2) / radius)
    }

    static massAndForceCentripetal(double mass, double forceCentripetal) {
        return answerFormatter(forceCentripetal / mass)
    }

    static radiusOnly(double radius) {
        Main.earthAssumption()
        return answerFormatter((Main.gravityConstant * Main.cMassOfEarth) / (radius**2))
    }

    static radiusAndPeriod(double radius, double period) {
        return answerFormatter((4 * (Math.PI)**2 * radius) / (period)**2)
    }

    static frequencyAndRadius(double frequency, double radius) {
        return answerFormatter((4 * (Math.PI)**2 * (radius)**2 * (frequency)**2) / (radius))
    }

    static answerFormatter(double answer) {
        return "The centripetal acceleration is: " + answer + " meters per second squared."
    }

}
