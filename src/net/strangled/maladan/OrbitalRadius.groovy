package net.strangled.maladan

/**
 * MaladaN(R)
 */
class OrbitalRadius {
    static gravityConstant = 6.67 * 10**-11
    static massOfEarth = 5.96 * 10**24

    static execute(LinkedList<String> info) {
        def mass = null
        def period = null
        def aC = null
        def velocity = null
        def frequency = null
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i) == '-m') {
                mass = info.get(i + 1)
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
        if (period && !mass && !aC && !velocity && !frequency) {
            return periodOnly(Double.valueOf(period))
        } else if (period && velocity && !mass && !aC && !frequency) {
            return periodAndVelocity(Double.valueOf(period), Double.valueOf(velocity))
        } else if (velocity && frequency && !period && !mass && !aC) {
            return frequencyAndVelocity(Double.valueOf(frequency), Double.valueOf(velocity))
        } else if (velocity && aC && !period && !frequency && !mass) {
            aCAndVelocity(Double.valueOf(aC), Double.valueOf(velocity))
        } else if (velocity && !aC && !period && !frequency && !mass) {
            velocityOnly(Double.valueOf(velocity))
        }
    }

    static periodOnly(double period) {
        earthAssumption()
        return answerFormatter(Math.cbrt((gravityConstant * massOfEarth * ((period)**2) / (4 * (Math.pow(Math.PI, 2))))))
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
        return answerFormatter(Math.sqrt((gravityConstant * massOfEarth) / (velocity)**2))
    }

    static answerFormatter(double answer) {
        return "The orbital radius is: " + answer + " meters."
    }
    static earthAssumption() {
        println('Assuming earth as object being orbited')
    }
}
