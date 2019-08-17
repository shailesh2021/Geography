import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.sin

class Geography {
    companion object{
        fun distance(point1: point, point2: point, unit: String = "m"): Double {
            if (point1 == point2) {
                return 0.0
            } else {
                val theta = point1.long - point2.long
                var dist = sin(Math.toRadians(point1.lat)) * sin(Math.toRadians(point2.lat)) + cos(Math.toRadians(point1.lat)) * cos(Math.toRadians(point2.lat)) * cos(Math.toRadians(theta))
                dist = acos(dist)
                dist = Math.toDegrees(dist)
                dist *= 60.0 * 1.1515
                if (unit === "K") {
                    dist *= 1.609344
                } else if (unit === "N") {
                    dist *= 0.8684
                } else if (unit === "m") {
                    dist *= 1609.344
                }
                return dist
            }
        }

        fun isPointInRadius(centerPoint: point, point: point, radius:Double, unit: String = "m"):Boolean{
            if (centerPoint == point) {
                return true
            } else {
                val theta = centerPoint.long - point.long
                var dist = sin(Math.toRadians(centerPoint.lat)) * sin(Math.toRadians(point.lat)) + cos(Math.toRadians(centerPoint.lat)) * cos(Math.toRadians(point.lat)) * cos(Math.toRadians(theta))
                dist = acos(dist)
                dist = Math.toDegrees(dist)
                dist *= 60.0 * 1.1515
                if (unit === "K") {
                    dist *= 1.609344
                    return dist <= radius
                } else if (unit === "N") {
                    dist *= 0.8684
                    return dist <= radius
                } else if (unit === "m") {
                    dist *= 1609.344
                    return dist <= radius
                }
                return false
            }
        }
    }
}

data class point(val lat:Double,val long:Double)