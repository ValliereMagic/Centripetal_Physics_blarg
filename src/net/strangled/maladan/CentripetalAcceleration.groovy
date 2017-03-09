package net.strangled.maladan

/**
 * MaladaN (R)
 */
class CentripetalAcceleration {
    static execute(LinkedList<String> info) {
        Options options = new Options(info)
        if (options.getSize() <= 2) {
            if (options.getVelocity() && options.getOrbitalRadius()) {
                velocityAndRadius(options.getVelocity(), options.getOrbitalRadius())
            } else if (options.getForceGravity() && options.getorMass()) {
                massAndForceGravity(options.getorMass(), options.getForceGravity())
            } else if (options.getOrbitalRadius()) {
                radiusOnly(options.getOrbitalRadius())
            }
        }
    }

    static velocityAndRadius(double velocity, double radius) {
        return answerFormatter((velocity**2) / radius)
    }

    static massAndForceGravity(double mass, double forceGravity) {
        return answerFormatter(forceGravity / mass)
    }

    static radiusOnly(double radius) {
        Main.earthAssumption()
        return answerFormatter((Main.gravityConstant * Main.cMassOfEarth) / radius)
    }

    static answerFormatter(double answer) {
        return "The centripetal acceleration is: " + answer + " meters per second squared."
    }

}
