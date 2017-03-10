package net.strangled.maladan

/**
 * MaladaN (R)
 */
class Options {
    private double cMass
    private double orMass
    private double period
    private double aC
    private double velocity
    private double frequency
    private double orbitalRadius
    private double forceGravity
    private int size

    Options(LinkedList<String> info) {
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i) == '-cm') {
                cMass = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-orm') {
                orMass = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-p') {
                period = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-cacc') {
                aC = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-v') {
                velocity = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-fr') {
                frequency = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-or') {
                orbitalRadius = Double.valueOf(info.get(i + 1))
                size++
            } else if (info.get(i) == '-fG') {
                forceGravity = Double.valueOf(info.get(i + 1))
                size++
            }
        }
    }

    double getcMass() {
        return cMass
    }

    double getOrMass() {
        return orMass
    }

    double getPeriod() {
        return period
    }

    double getaC() {
        return aC
    }

    double getVelocity() {
        return velocity
    }

    double getFrequency() {
        return frequency
    }

    double getOrbitalRadius() {
        return orbitalRadius
    }

    double getForceGravity() {
        return forceGravity
    }

    int getSize() {
        return size
    }
}
