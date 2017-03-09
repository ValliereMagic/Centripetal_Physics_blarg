package net.strangled.maladan

/**
 * MaladaN (R)
 */
class AvailableParameters {
    private test = [:]

    AvailableParameters(Options options) {
        if (options.getPeriod() && !options.getVelocity() && !options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            test.put("period", options.getPeriod())
        } else if (options.getPeriod() && options.getVelocity() && !options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            test.put("period", options.getPeriod())
            test.put("velocity", options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            test.put("frequency", options.getFrequency())
            test.put("velocity", options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && !options.getFrequency() && options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            test.put("acceleration", options.getaC())
            test.put("velocity", options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && !options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            test.put("velocity", options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && !options.getFrequency() && !options.getaC() && options.getcMass() && !options.getOrbitalRadius()) {
            test.put("cMass", options.getcMass())
            test.put("velocity", options.getVelocity())
        } else if (options.getPeriod() && !options.getVelocity() && !options.getFrequency() && !options.getaC() && options.getcMass() && !options.getOrbitalRadius()) {
            test.put("period", options.getPeriod())
            test.put("cMass", options.getcMass())
        } else {
            test.put("Error", "Either not enough data supplied, or parameters not supported.")
        }
    }
}
