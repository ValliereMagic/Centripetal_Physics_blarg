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
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i) == '-m') {
                mass = info.get(i + 1)
            } else if (info.get(i) == '-p') {
                period = info.get(i + 1)
            } else if (info.get(i) == '-cacc') {
                aC = info.get(i + 1)
            } else if (info.get(i) == '-v') {
                velocity = info.get(i + 1)
            }
        }
        if (period && !mass && !aC && !velocity) {
            return periodOnly(Double.valueOf(period))
        } else if (period && velocity && !mass && !aC) {
            periodAndVelocity(Double.valueOf(period), Double.valueOf(velocity))
        }
    }

    static periodOnly(double period) {
        println('Assuming earth as object being orbited')
        def radiusAnswer = Math.cbrt((gravityConstant * massOfEarth * (Math.pow(period, 2))) / (4 * (Math.pow(Math.PI, 2))))
        return "The orbital radius is: " + radiusAnswer + " meters."
    }

    static periodAndVelocity(double period, double velocity) {
        def radiusAnswer = (velocity * period) / (2 * (Math.PI))
        return "The orbital radius is: " + radiusAnswer + " meters."
    }
}
