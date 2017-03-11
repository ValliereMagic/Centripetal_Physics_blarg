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
            } else if (options.getForceGravity() && options.getOrMass()) {
                massAndForceGravity(options.getOrMass(), options.getForceGravity())
            } else if (options.getOrbitalRadius() && options.getPeriod()) {
                radiusAndPeriod(options.getOrbitalRadius(), options.getPeriod())
            } else {
                return Main.errorMessage
            }
        } else if (options.getSize() == 1) {
            if (options.getOrbitalRadius()) {
                radiusOnly(options.getOrbitalRadius())
            }
        } else {
            return Main.errorMessage
        }
    }

    static velocityAndRadius(double velocity, double radius) {
        return answerFormatter((velocity**2) / radius)
    }
    //Logic under review
    static massAndForceGravity(double mass, double forceGravity) {
        return answerFormatter(forceGravity / mass)
    }
    //Logic under review
    static radiusOnly(double radius) {
        Main.earthAssumption()
        return answerFormatter((Main.gravityConstant * Main.cMassOfEarth) / radius)
    }

    static radiusAndPeriod(double radius, double period) {
        return answerFormatter((4 * (Math.PI)**2 * radius) / (period)**2)
    }

    static answerFormatter(double answer) {
        return "The centripetal acceleration is: " + answer + " meters per second squared."
    }

}
