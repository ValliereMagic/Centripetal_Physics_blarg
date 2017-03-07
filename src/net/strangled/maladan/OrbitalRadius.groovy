package net.strangled.maladan

/**
 * MaladaN(R)
 */
class OrbitalRadius {
    static gravityConstant = 6.67*10**-11
    static massOfEarth = 5.96*10**24
    static execute(LinkedList<String> info) {
        def mass = null
        def radius = null
        def period = null
        for (int i = 0; i < info.size(); i++) {
            if (info.get(i) == '-m') {
                mass = info.get(i + 1)
            } else if (info.get(i) == '-r') {
                radius = info.get(i + 1)
            } else if (info.get(i) == '-p') {
                period = info.get(i + 1)
            }
        }
        if (period && !radius && !mass) {
            println('Assuming earth as object being orbited')
            def radiusAnswer = Math.cbrt((gravityConstant*massOfEarth*(Math.pow(Double.valueOf(period), 2)))/(4*(Math.pow(Math.PI, 2))))
            return "The orbital radius is: " + radiusAnswer + " meters."
        }
    }
}
