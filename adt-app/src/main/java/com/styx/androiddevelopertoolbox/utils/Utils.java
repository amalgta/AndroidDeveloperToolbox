package com.styx.androiddevelopertoolbox.utils;

/**
 * Created by amalg on 16-06-2016.
 */
public class Utils {
    public static class DensityCalculator {
        static boolean rounded = true;
        private static double baseNonRetina = 1;
        private static double baseHDPI = 1.5;
        private static double baseRetina = 2;
        private static double baseXHDPI = 2.25;

        private static double scale(double value, double multiplier) {
            if (rounded) {
                double num = value * multiplier;
                double newNum;
                if ((Math.floor(num) % 2 == 0) && (Math.abs(num - Math.floor(num)) == 0.5)) {
                    newNum = Math.round(num) - 1;
                } else {
                    newNum = Math.round(num);
                }
                return (newNum);
            } else {
                return ((int) (value * multiplier));
            }
        }

        public static Double[][] getDensity(RES density, double height, double width) {
            Double scaleNonRetina = 1.0;
            Double scaleHDPI = 1.0;
            Double scaleRetina = 1.0;
            Double scaleXHDPI = 1.0;
            Double[][] calculatedDensity = new Double[4][2];

            if (density == Utils.DensityCalculator.RES.MDPI) {
                scaleNonRetina = baseNonRetina / baseNonRetina;
                scaleHDPI = baseHDPI / baseNonRetina;
                scaleRetina = baseRetina / baseNonRetina;
                scaleXHDPI = baseXHDPI / baseNonRetina;
            } else if (density == Utils.DensityCalculator.RES.HDPI) {

                scaleNonRetina = baseNonRetina / baseHDPI;
                scaleHDPI = baseHDPI / baseHDPI;
                scaleRetina = baseRetina / baseHDPI;
                scaleXHDPI = baseXHDPI / baseHDPI;
            } else if (density == Utils.DensityCalculator.RES.RETINA) {
                scaleNonRetina = baseNonRetina / baseRetina;
                scaleHDPI = baseHDPI / baseRetina;
                scaleRetina = baseRetina / baseRetina;
                scaleXHDPI = baseXHDPI / baseRetina;
            } else if (density == Utils.DensityCalculator.RES.XHDPI) {
                scaleNonRetina = baseNonRetina / baseXHDPI;
                scaleHDPI = baseHDPI / baseXHDPI;
                scaleRetina = baseRetina / baseXHDPI;
                scaleXHDPI = baseXHDPI / baseXHDPI;
            }

            calculatedDensity[0][0] = scale(height, scaleNonRetina);
            calculatedDensity[0][1] = scale(width, scaleNonRetina);

            calculatedDensity[1][0] = scale(height, scaleHDPI);
            calculatedDensity[1][1] = scale(width, scaleHDPI);

            calculatedDensity[2][0] = scale(height, scaleRetina);
            calculatedDensity[2][1] = scale(width, scaleRetina);

            calculatedDensity[3][0] = scale(height, scaleXHDPI);
            calculatedDensity[3][1] = scale(width, scaleXHDPI);

            return calculatedDensity;
        }

        public enum RES {
            MDPI, HDPI, RETINA, XHDPI
        }
    }
}

