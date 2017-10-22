package ve.com.joalbert.pipe;

/**
 * This class is part of the model for MVP pattern as well as package measurementvariables
 */

public class Pipe {
    private final int nominalSize;
    private final int schedule;

    public static int lastSchedule=Pipe.SCH_XXS;
    public static int lastNominalSize=Pipe.FORTY_AND_EIGHT;


    // Indexes for the nominal size
    public static final int ONE_EIGHT = 0;
    public static final int ONE_FOURTH = 1;
    public static final int THIRD_EIGHT = 2;
    public static final int ONE_HALF = 3;
    public static final int THIRD_FOURTH = 4;
    public static final int ONE = 5;
    public static final int ONE_AND_ONE_FOURTH = 6;
    public static final int ONE_AND_ONE_HALF = 7;
    public static final int TWO = 8;
    public static final int TWO_AND_ONE_HALF = 9;
    public static final int THREE = 10;
    public static final int THREE_AND_ONE_HALF = 11;
    public static final int FOUR = 12;
    public static final int FIVE = 13;
    public static final int SIX = 14;
    public static final int EIGHT = 15;
    public static final int TEN = 16;
    public static final int TWELVE = 17;
    public static final int FOURTEEN = 18;
    public static final int SIXTEEN = 19;
    public static final int EIGHTEEN = 20;
    public static final int TWENTY = 21;
    public static final int TWENTY_AND_TWO = 22;
    public static final int TWENTY_AND_FOUR = 23;
    public static final int TWENTY_AND_SIX = 24;
    public static final int TWENTY_AND_EIGHT = 25;
    public static final int THIRTY = 26;
    public static final int THIRTY_AND_TWO = 27;
    public static final int THIRTY_AND_FOUR = 28;
    public static final int THIRTY_AND_SIX = 29;
    public static final int THIRTY_AND_EIGHT = 30;
    public static final int FORTY = 31;
    public static final int FORTY_AND_TWO = 32;
    public static final int FORTY_AND_FOUR = 33;
    public static final int FORTY_AND_SIX = 34;
    public static final int FORTY_AND_EIGHT = 35;

    // Indexes for the schedule
    public static final int SCH_5S = 0;
    public static final int SCH_5 = 1;
    public static final int SCH_10S = 2;
    public static final int SCH_1O = 3;
    public static final int SCH_20 = 4;
    public static final int SCH_30 = 5;
    public static final int SCH_40S = 6;
    public static final int SCH_STD = 7;
    public static final int SCH_40 = 8;
    public static final int SCH_60 = 9;
    public static final int SCH_80S = 10;
    public static final int SCH_XS = 11;
    public static final int SCH_80 = 12;
    public static final int SCH_1OO = 13;
    public static final int SCH_120 = 14;
    public static final int SCH_140 = 15;
    public static final int SCH_160 = 16;
    public static final int SCH_XXS = 17;


    private final static double[] listOutsideDiameter = {
            0.405, 0.54, 0.675, 0.84, 1.05, 1.315, 1.66, 1.9, 2.375, 2.875, 3.5, 4.0, 4.5, 5.563,
            6.625, 8.625, 10.75, 12.75, 14.0, 16.0, 18.0, 20.0, 22.0, 24.0, 26.0, 28.0, 30.0, 32.0,
            34.0, 36.0, 38.0, 40.0, 42.0, 44.0, 46.0, 48.0
    };

    //As per ASME B36.10M and ASME B36.19M-1985
    private final static double[][] listThickness = {
 /* 1/8*/   {-1.0, -1.0, 0.049, 0.049, -1.0, 0.057, 0.068, 0.068, 0.068, -1.0, 0.095, 0.095,
            0.095, -1.0, -1.0, -1.0, -1.0, -1.0},
 /* 1/4*/   {-1.0, -1.0, 0.065, 0.065, -1.0, 0.073, 0.088, 0.088, 0.088, -1.0, 0.119, 0.119,
            0.119, -1.0, -1.0, -1.0, -1.0, -1.0},
 /* 3/8*/   {-1.0, -1.0, 0.065, 0.065, -1.0, 0.073, 0.091, 0.091, 0.091, -1.0, 0.126, 0.126,
            0.126, -1.0, -1.0, -1.0, -1.0, -1.0},
 /* 1/2*/   {0.065, 0.065, 0.083, 0.083, -1.0, 0.095, 0.109, 0.109, 0.109, -1.0, 0.147, 0.147,
            0.147, -1.0, -1.0, -1.0, 0.188, 0.294},
 /* 3/4*/   {0.065, 0.065, 0.083, 0.083, -1.0, 0.095, 0.113, 0.113, 0.113, -1.0, 0.154, 0.154,
            0.154, -1.0, -1.0, -1.0, 0.219, 0.308},
/* 1*/      {0.065, 0.065, 0.109, 0.109, -1.0, 0.114, 0.133, 0.133, 0.133, -1.0, 0.179, 0.179,
            0.179, -1.0, -1.0, -1.0, 0.25, 0.358},
/* 1 1/4*/  {0.065, 0.065, 0.109, 0.109, -1.0, 0.117, 0.14, 0.14, 0.14, -1.0, 0.191, 0.191, 0.191,
            -1.0, -1.0, -1.0, 0.25, 0.382},
/* 1 1/2*/  {0.065, 0.065, 0.109, 0.109, -1.0, 0.125, 0.145, 0.145, 0.145, -1.0, 0.2, 0.2, 0.2,
            -1.0, -1.0, -1.0, 0.281, 0.4},
/* 2*/      {0.065, 0.065, 0.109, 0.109, -1.0, 0.125, 0.154, 0.154, 0.154, -1.0, 0.218, 0.218,
            0.218, -1.0, -1.0, -1.0, 0.344, 0.436},
/* 2 1/2*/  {0.083, 0.083, 0.12, 0.12, -1.0, 0.188, 0.203, 0.203, 0.203, -1.0, 0.276, 0.276, 0.276,
            -1.0, -1.0, -1.0, 0.375, 0.552},
/* 3*/      {0.083, 0.083, 0.12, 0.12, -1.0, 0.188, 0.216, 0.216, 0.216, -1.0, 0.3, 0.3, 0.3, -1.0,
            -1.0, -1.0, 0.438, 0.6},
/* 3 1/2*/  {0.083, 0.083, 0.12, 0.12, -1.0, 0.188, 0.226, 0.226, 0.226, -1.0, 0.318, 0.318, 0.318,
            -1.0, -1.0, -1.0, -1.0, -1.0},
/* 4*/      {0.083, 0.083, 0.12, 0.12, -1.0, 0.188, 0.237, 0.237, 0.237, -1.0, 0.337, 0.337, 0.337,
            -1.0, 0.438, -1.0, 0.531, 0.674},
/* 5*/      {0.109, 0.109, 0.134, 0.134, -1.0, -1.0, 0.258, 0.258, 0.258, -1.0, 0.375, 0.375, 0.375,
            -1.0, 0.5, -1.0, 0.625, 0.75},
/* 6*/      {0.109, 0.109, 0.134, 0.134, -1.0, -1.0, 0.28, 0.28, 0.28, -1.0, 0.432, 0.432, 0.432,
            -1.0, 0.562, -1.0, 0.719, 0.864},
/* 8*/      {0.109, 0.109, 0.148, 0.148, 0.25, 0.277, 0.322, 0.322, 0.322, 0.406, 0.5, 0.5, 0.5,
            0.594, 0.719, 0.812, 0.906, 0.875},
/* 10*/     {0.134, 0.134, 0.165, 0.165, 0.25, 0.307, 0.365, 0.365, 0.365, 0.5, 0.5, 0.5, 0.594,
            0.719, 0.844, 1.0, 1.125, 1.0},
/* 12*/     {0.156, 0.156, 0.18, 0.18, 0.25, 0.33, 0.375, 0.375, 0.406, 0.562, 0.5, 0.5, 0.688,
            0.844, 1.0, 1.125, 1.312, 1.0},
/* 14*/     {0.156, 0.156, 0.188, 0.25, 0.312, 0.375, 0.375, 0.375, 0.438, 0.594, 0.5, 0.5, 0.75,
            0.938, 1.094, 1.25, 1.406, -1.0},
/* 16*/     {0.165, 0.165, 0.188, 0.25, 0.312, 0.375, 0.375, 0.375, 0.5, 0.656, 0.5, 0.5, 0.844,
            1.031, 1.219, 1.438, 1.594, -1.0},
/* 18*/     {0.165, 0.165, 0.188, 0.25, 0.312, 0.438, 0.375, 0.375, 0.562, 0.75, 0.5, 0.5, 0.938,
            1.156, 1.375, 1.562, 1.781, -1.0},
/* 20*/     {0.188, 0.188, 0.218, 0.25, 0.375, 0.5, 0.375, 0.375, 0.594, 0.812, 0.5, 0.5, 1.031,
            1.281, 1.5, 1.75, 1.969, -1.0},
/* 22*/     {0.188, 0.188, 0.218, 0.25, 0.375, 0.5, -1.0, 0.375, -1.0, 0.875, -1.0, 0.5, 1.125,
            1.375, 1.625, 1.875, 2.125, -1.0},
/* 24*/     {0.218, 0.218, 0.25, 0.25, 0.375, 0.562, 0.375, 0.375, 0.688, 0.969, 0.5, 0.5, 1.219,
            1.531, 1.812, 2.062, 2.344, -1.0},
/* 26*/     {-1.0, -1.0, -1.0, 0.312, 0.5, -1.0, -1.0, 0.375, -1.0, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 28*/     {-1.0, -1.0, -1.0, 0.312, 0.5, 0.625, -1.0, 0.375, -1.0, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 30*/     {0.25, 0.25, 0.312, 0.312, 0.5, 0.625, -1.0, 0.375, -1.0, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 32*/     {-1.0, -1.0, -1.0, 0.312, 0.5, 0.625, -1.0, 0.375, 0.688, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 34*/     {-1.0, -1.0, -1.0, 0.312, 0.5, 0.625, -1.0, 0.375, 0.688, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 36*/     {-1.0, -1.0, -1.0, 0.312, 0.5, 0.625, -1.0, 0.375, 0.75, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 38*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.375, 0.75, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 40*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.375, 0.75, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 42*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.375, -1.0, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 44*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.375, 0.75, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 46*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.375, 0.75, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 48*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 0.375, -1.0, -1.0, -1.0, 0.5, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0}
    };

    private final static double[][] listWeightPerFoot = {
 /* 1/8*/   {-1.0, -1.0, 0.19, 0.19, -1.0, 0.21, 0.24, 0.24, 0.24, -1.0, 0.31, 0.31, 0.31, -1.0,
            -1.0, -1.0, -1.0, -1.0},
 /* 1/4*/   {-1.0, -1.0, 0.33, 0.33, -1.0, 0.36, 0.43, 0.43, 0.43, -1.0, 0.54, 0.54, 0.54, -1.0,
            -1.0, -1.0, -1.0, -1.0},
 /* 3/8*/   {-1.0, -1.0, 0.42, 0.42, -1.0, 0.47, 0.57, 0.57, 0.57, -1.0, 0.74, 0.74, 0.74, -1.0,
            -1.0, -1.0, -1.0, -1.0},
 /* 1/2*/   {0.54, 0.54, 0.67, 0.67, -1.0, 0.76, 0.85, 0.85, 0.85, -1.0, 1.09, 1.09, 1.09, -1.0,
            -1.0, -1.0, 1.31, 1.72},
 /* 3/4*/   {0.68, 0.69, 0.86, 0.86, -1.0, 0.97, 1.13, 1.13, 1.13, -1.0, 1.48, 1.48, 1.48, -1.0,
            -1.0, -1.0, 1.95, 2.44},
/* 1*/      {0.87, 0.87, 1.41, 1.41, -1.0, 1.46, 1.68, 1.68, 1.68, -1.0, 2.17, 2.17, 2.17, -1.0,
            -1.0, -1.0, 2.85, 3.66},
/* 1 1/4*/  {1.11, 1.11, 1.81, 1.81, -1.0, 1.93, 2.27, 2.27, 2.27, -1.0, 3.0, 3.0, 3.0, -1.0,
            -1.0, -1.0, 3.77, 5.22},
/* 1 1/2*/  {1.28, 1.28, 2.09, 2.09, -1.0, 2.37, 2.72, 2.72, 2.72, -1.0, 3.63, 3.63, 3.63, -1.0,
            -1.0, -1.0, 4.86, 6.41},
/* 2*/      {1.61, 1.61, 2.64, 2.64, -1.0, 3.01, 3.66, 3.66, 3.66, -1.0, 5.03, 5.03, 5.03, -1.0,
            -1.0, -1.0, 7.47, 9.04},
/* 2 1/2*/  {2.48, 2.48, 3.53, 3.53, -1.0, 5.4, 5.8, 5.8, 5.8, -1.0, 7.67, 7.67, 7.67, -1.0, -1.0,
            -1.0, 10.02, 13.71},
/* 3*/      {3.03, 3.03, 4.34, 4.34, -1.0, 6.66, 7.58, 7.58, 7.58, -1.0, 10.26, 10.26, 10.26, -1.0,
            -1.0, -1.0, 14.34, 18.6},
/* 3 1/2*/  {3.48, 3.48, 4.98, 4.98, -1.0, 7.66, 9.12, 9.12, 9.12, -1.0, 12.52, 12.52, 12.52, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 4*/      {3.92, 3.92, 5.62, 5.62, -1.0, 8.67, 10.8, 10.8, 10.8, -1.0, 15.0, 15.0, 15.0, -1.0,
            19.02, -1.0, 22.53, 27.57},
/* 5*/      {6.36, 6.36, 7.78, 7.78, -1.0, -1.0, 14.63, 14.63, 14.63, -1.0, 20.8, 20.8, 20.8, -1.0,
            27.06, -1.0, 32.99, 38.59},
/* 6*/      {7.59, 7.59, 9.3, 9.3, -1.0, -1.0, 18.99, 18.99, 18.99, -1.0, 28.6, 28.6, 28.6, -1.0,
            36.43, -1.0, 45.39, 53.21},
/* 8*/      {9.92, 9.92, 13.41, 13.41, 22.38, 24.72, 28.58, 28.58, 28.58, 35.67, 43.43, 43.43,
            43.43, 51, 60.77, 67.82, 74.76, 72.49},
/* 10*/     {15.21, 15.21, 18.67, 18.67, 28.06, 34.27, 40.52, 40.52, 40.52, 54.79, 54.79, 54.79,
            64.49, 77.1, 89.38, 104.23, 115.75, 104.23},
/* 12*/     {21.0, 21.0, 24.19, 24.19, 33.41, 43.81, 49.61, 49.61, 53.57, 73.22, 65.48, 65.48, 88.71,
            107.42, 125.61, 139.81, 160.42, 125.61},
/* 14*/     {23.09, 23.09, 27.76, 36.75, 45.65, 54.62, 54.62, 54.62, 63.5, 85.13, 72.16, 72.16,
            106.23, 130.98, 150.93, 170.37, 189.29, -1.0},
/* 16*/     {27.93, 27.93, 31.78, 42.09, 52.32, 62.64, 62.64, 62.64, 82.85, 107.6, 82.85, 82.85,
            136.74, 164.98, 192.61, 223.85, 245.48, -1.0},
/* 18*/     {31.46, 31.46, 35.8, 47.44, 58.99, 82.23, 70.65, 70.65, 104.76, 138.3, 93.54, 93.54,
            171.08, 208.15, 244.37, 274.48, 308.79, -1.0},
/* 20*/     {39.82, 39.82, 46.1, 52.78, 78.67, 104.23, 78.67, 78.67, 123.23, 166.56, 104.23,
            104.23, 209.06, 256.34, 296.65, 341.41, 379.53, -1.0},
/* 22*/     {43.84, 43.84, 50.76, 58.13, 86.69, 114.92, -1.0, 86.69, -1.0, 197.6, -1.0, 114.92,
            251.05, 303.16, 353.94, 403.38, 451.49, -1.0},
/* 24*/     {55.42, 55.42, 63.47, 63.47, 94.71, 140.81, 94.71, 94.71, 171.45, 238.57,
            125.61, 125.61, 296.86, 367.74, 429.79, 483.57, 542.64, -1.0},
/* 26*/     {-1.0, -1.0, -1.0, 85.68, 136.3, -1.0, -1.0, 102.72, -1.0, -1.0, -1.0, 136.3, -1.0,
            -1.0, -1.0, -1.0, -1.0, -1.0},
/* 28*/     {-1.0, -1.0, -1.0, 92.35, 146.99, 182.9, -1.0, 110.74, -1.0, -1.0, -1.0, 146.99, -1.0,
            -1.0, -1.0, -1.0, -1.0, -1.0},
/* 30*/     {79.51, 79.51, 99.02, 99.02, 157.68, 196.26, -1.0, 118.76, -1.0, -1.0, -1.0, 157.68,
            -1.0, -1.0, -1.0, -1.0, -1.0, -1.0},
/* 32*/     {-1.0, -1.0, -1.0, 105.69, 168.37, 209.62, -1.0, 126.78, 230.29, -1.0, -1.0, 168.37,
            -1.0, -1.0, -1.0, -1.0, -1.0, -1.0},
/* 34*/     {-1.0, -1.0, -1.0, 112.36, 179.06, 222.99, -1.0, 134.79, 245, -1.0, -1.0, 179.06, -1.0,
            -1.0, -1.0, -1.0, -1.0, -1.0},
/* 36*/     {-1.0, 119.03, -1.0, -1.0, 189.75, 236.35, -1.0, 142.81, 282.62, -1.0, -1.0, 189.75,
            -1.0, -1.0, -1.0, -1.0, -1.0, -1.0},
/* 38*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 150.83, -1.0, -1.0, -1.0, 200.44, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 40*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 158.85, -1.0, -1.0, -1.0, 211.13, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 42*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 166.86, -1.0, -1.0, -1.0, 221.82, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 44*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 174.88, -1.0, -1.0, -1.0, 232.51, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 46*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 182.9, -1.0, -1.0, -1.0, 243.2, -1.0, -1.0,
            -1.0, -1.0, -1.0, -1.0},
/* 48*/     {-1.0, -1.0, -1.0, -1.0, -1.0, -1.0, -1.0, 190.92, -1.0, -1.0, -1.0, 253.89, -1.0,
            -1.0, -1.0, -1.0, -1.0, -1.0}
    };

    /** constructor a pipe object
     * @param nominalSize array with all ids from the EditText in the ViewGroup
     * @param schedule View where the EditText are available
     * */
    public Pipe(final int nominalSize, final int schedule) {
        this.nominalSize = nominalSize;
        this.schedule = schedule;
    }

    /** Getter method for outside diameter for the class, it assumes that values selected
     * are correct indexes for the array
     * @param nominalSize index used to look for outside diameter
     * @return a double value with the outside diameter
     * */
    public static double getOutsideDiameter(final int nominalSize) {
        return listOutsideDiameter[nominalSize];
    }

    /** Getter method for thickness of the pipe for the class, it assumes that values selected
     * are correct indexes for the array
     * @param nominalSize index used to look for outside diameter
     * @param schedule index used to look for schedule
     * @return a double value with the thickness of the pipe
     * */
    public static double getThickness(final int nominalSize, final int schedule) {
        return listThickness[nominalSize][schedule];
    }

    /** Getter method for weight per foot of the pipe for the class, it assumes that values selected
     * are correct indexes for the array
     * @param nominalSize index used to look for outside diameter
     * @param schedule index used to look for schedule
     * @return a double value with the weight per foot of the pipe
     * */
    public static double getWeight(final int nominalSize, final int schedule) {
        return listWeightPerFoot[nominalSize][schedule];
    }

    /** Getter method for inside diameter of the pipe for the class, it assumes that values selected
     * are correct indexes for the array
     * @param nominalSize index used to look for outside diameter
     * @param schedule index used to look for schedule
     * @return a double with the inside diameter of the pipe, if thickness not apply
     * for the nominal size and schedule selected then return -1.
     * */
    public static double getInsideDiameter(final int nominalSize, final int schedule) {
        double outsideDiameter = getOutsideDiameter(nominalSize);
        double thickness =getThickness(nominalSize, schedule);
        return  thickness == -1 ? -1: outsideDiameter - thickness;
    }

    /** Getter method for get nominal size pipe index
     * @return a int value with the nominal size
     * */
    public int getNominalSize() {
        return nominalSize;
    }

    /** Getter method for getting schedule index
     * @return a int value with the schedule
     * */
    public int getSchedule() {
        return schedule;
    }

    /** Getter method for getting inside diameter for the instance
     * @return a int value with the schedule
     * */
    public double getInsideDiameter() {
        return getInsideDiameter(nominalSize, schedule);
    }

/** Getter method for weight per foot of the pipe for the instance, it assumes that values selected
  are correct indexes for the array
 */
 public double getWeight(){
        return getWeight(nominalSize,schedule);
    }

    /** Getter method for outside diameter for the instance, it assumes that values selected
     * are correct indexes for the array
     * @return a double value with the outside diameter
     * */
    public double getOutsideDiameter() {
        return getOutsideDiameter(nominalSize);
    }

    /** Getter method for thickness of the pipe for the instance, it assumes that values selected
     * are correct indexes for the array
     * @return a double value with the thickness of the pipe
     * */
    public double getThickness(){
        return listThickness[nominalSize][schedule];
    }





}
