package storm.starter;
/*
  Licensed under the Apache License, Version 2.0
    http://www.apache.org/licenses/LICENSE-2.0.html

  AUTOGENERATED BY H2O at 2016-05-13T17:58:10.138-07:00
  3.8.1.3
  
  Standalone prediction code with sample test data for GBMModel named GBMPojo

  How to download, compile and execute:
      mkdir tmpdir
      cd tmpdir
      curl http://127.0.0.1:54321/3/h2o-genmodel.jar > h2o-genmodel.jar
      curl http://127.0.0.1:54321/3/Models.java/GBMPojo > GBMPojo.java
      javac -cp h2o-genmodel.jar -J-Xmx2g -J-XX:MaxPermSize=128m GBMPojo.java

     (Note:  Try java argument -XX:+PrintCompilation to show runtime JIT compiler behavior.)
*/
import java.util.Map;
import hex.genmodel.GenModel;
import hex.genmodel.annotations.ModelPojo;

@ModelPojo(name="GBMPojo", algorithm="gbm")
public class GBMPojo extends GenModel {
  public hex.ModelCategory getModelCategory() { return hex.ModelCategory.Binomial; }

  public boolean isSupervised() { return true; }
  public int nfeatures() { return 15; }
  public int nclasses() { return 2; }

  // Names of columns used by model.
  public static final String[] NAMES = NamesHolder_GBMPojo.VALUES;
  // Number of output classes included in training data response column.
  public static final int NCLASSES = 2;

  // Column domains. The last array contains domain of response column.
  public static final String[][] DOMAINS = new String[][] {
    /* Has4Legs */ null,
    /* CoatColor */ GBMPojo_ColInfo_1.VALUES,
    /* HairLength */ null,
    /* TailLength */ null,
    /* EnjoysPlay */ null,
    /* StairsOutWindow */ null,
    /* HoursSpentNapping */ null,
    /* RespondsToCommands */ null,
    /* EasilyFrightened */ null,
    /* Age */ null,
    /* Noise1 */ null,
    /* Noise2 */ null,
    /* Noise3 */ null,
    /* Noise4 */ null,
    /* Noise5 */ null,
    /* Label */ GBMPojo_ColInfo_15.VALUES
  };
  // Prior class distribution
  public static final double[] PRIOR_CLASS_DISTRIB = {0.327,0.673};
  // Class distribution used for model building
  public static final double[] MODEL_CLASS_DISTRIB = {0.327,0.673};

  public GBMPojo() { super(NAMES,DOMAINS); }
  public String getUUID() { return Long.toString(5946973926525812506L); }

  // Pass in data in a double[], pre-aligned to the Model's requirements.
  // Jam predictions into the preds[] array; preds[0] is reserved for the
  // main prediction (class for classifiers or value for regression),
  // and remaining columns hold a probability distribution for classifiers.
  public final double[] score0( double[] data, double[] preds ) {
    java.util.Arrays.fill(preds,0);
    double[] fdata = hex.genmodel.GenModel.SharedTree_clean(data);
    GBMPojo_Forest_0.score0(fdata,preds);
    GBMPojo_Forest_1.score0(fdata,preds);
    GBMPojo_Forest_2.score0(fdata,preds);
    GBMPojo_Forest_3.score0(fdata,preds);
    GBMPojo_Forest_4.score0(fdata,preds);
    GBMPojo_Forest_5.score0(fdata,preds);
    GBMPojo_Forest_6.score0(fdata,preds);
    GBMPojo_Forest_7.score0(fdata,preds);
    GBMPojo_Forest_8.score0(fdata,preds);
    GBMPojo_Forest_9.score0(fdata,preds);
    preds[2] = preds[1] + 0.7217851587474746;
    preds[2] = 1/(1+Math.min(1.0E19, Math.exp(-preds[2])));
    preds[1] = 1.0-preds[2];
    preds[0] = hex.genmodel.GenModel.getPrediction(preds, PRIOR_CLASS_DISTRIB, data, 0.5539907993586999);
    return preds;
  }
}
// The class representing training column names
class NamesHolder_GBMPojo implements java.io.Serializable {
  public static final String[] VALUES = new String[15];
  static {
    NamesHolder_GBMPojo_0.fill(VALUES);
  }
  static final class NamesHolder_GBMPojo_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "Has4Legs";
      sa[1] = "CoatColor";
      sa[2] = "HairLength";
      sa[3] = "TailLength";
      sa[4] = "EnjoysPlay";
      sa[5] = "StairsOutWindow";
      sa[6] = "HoursSpentNapping";
      sa[7] = "RespondsToCommands";
      sa[8] = "EasilyFrightened";
      sa[9] = "Age";
      sa[10] = "Noise1";
      sa[11] = "Noise2";
      sa[12] = "Noise3";
      sa[13] = "Noise4";
      sa[14] = "Noise5";
    }
  }
}
// The class representing column CoatColor
class GBMPojo_ColInfo_1 implements java.io.Serializable {
  public static final String[] VALUES = new String[5];
  static {
    GBMPojo_ColInfo_1_0.fill(VALUES);
  }
  static final class GBMPojo_ColInfo_1_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "Black";
      sa[1] = "Brown";
      sa[2] = "Grey";
      sa[3] = "Spotted";
      sa[4] = "White";
    }
  }
}
// The class representing column Label
class GBMPojo_ColInfo_15 implements java.io.Serializable {
  public static final String[] VALUES = new String[2];
  static {
    GBMPojo_ColInfo_15_0.fill(VALUES);
  }
  static final class GBMPojo_ColInfo_15_0 implements java.io.Serializable {
    static final void fill(String[] sa) {
      sa[0] = "cat";
      sa[1] = "dog";
    }
  }
}

class GBMPojo_Forest_0 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_0_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_0_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.0880019f
          : (data[13 /* Noise4 */] <0.018522263f
            ? 0.11613135f
            : (data[9 /* Age */] != 9.0f ? 0.1485884f : 0.13235988f)))
        : 0.012268769f)
      : (data[3 /* TailLength */] <3.5f
        ? (data[7 /* RespondsToCommands */] <0.5f
          ? -0.22061062f
          : (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */])
            ? -0.01664752f
            : (data[9 /* Age */] <16.5f ? 0.1485884f : 0.10314853f)))
        : (data[2 /* HairLength */] <0.5f
          ? (data[7 /* RespondsToCommands */] <0.5f ? -0.3058104f : -0.01664752f)
          : (data[3 /* TailLength */] <5.5f
            ? (data[13 /* Noise4 */] <0.77806145f ? -0.27741045f : -0.16949075f)
            : -0.3058104f))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
  // {01110000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {14, 0, 0, 0};
}


class GBMPojo_Forest_1 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_1_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_1_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.08193019f
          : (data[3 /* TailLength */] <6.0f
            ? (data[13 /* Noise4 */] <0.018522263f ? 0.1432611f : 0.14191039f)
            : (data[5 /* StairsOutWindow */] <0.5f ? 0.062075198f : 0.14195327f)))
        : 0.011091855f)
      : (data[3 /* TailLength */] <2.5f
        ? (data[12 /* Noise3 */] <0.48935533f ? 0.1432584f : 0.14826086f)
        : (data[2 /* HairLength */] <0.5f
          ? (data[7 /* RespondsToCommands */] <0.5f ? -0.22357261f : 0.026138676f)
          : (data[3 /* TailLength */] <5.5f
            ? (data[7 /* RespondsToCommands */] <0.5f ? -0.25129077f : -0.0577745f)
            : -0.25158477f))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
}


class GBMPojo_Forest_2 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_2_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_2_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.07633824f
          : (data[13 /* Noise4 */] <0.018522263f
            ? 0.10180137f
            : (data[9 /* Age */] != 9.0f ? 0.13639407f : 0.11893812f)))
        : 0.010024107f)
      : (data[3 /* TailLength */] <2.5f
        ? (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */]) ? 0.1380213f : 0.14185244f)
        : (data[2 /* HairLength */] <0.5f
          ? (data[6 /* HoursSpentNapping */] != 5.0f
            ? (data[13 /* Noise4 */] <0.4193629f ? 0.106760025f : -0.068484366f)
            : -0.20978732f)
          : (data[3 /* TailLength */] <5.5f
            ? (data[7 /* RespondsToCommands */] <0.5f ? -0.21600579f : -0.05106811f)
            : -0.21786739f))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
  // {00101000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {20, 0, 0, 0};
}


class GBMPojo_Forest_3 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_3_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_3_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.07114688f
          : (data[3 /* TailLength */] <6.0f
            ? (data[13 /* Noise4 */] <0.018522263f ? 0.13385855f : 0.13175501f)
            : (data[5 /* StairsOutWindow */] <0.5f ? 0.0474084f : 0.13182291f)))
        : 0.009055963f)
      : (data[3 /* TailLength */] <3.5f
        ? (data[7 /* RespondsToCommands */] <0.5f
          ? -0.1425962f
          : (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */])
            ? -0.023629116f
            : (data[12 /* Noise3 */] <0.6257176f ? 0.13694423f : 0.089702204f)))
        : (data[8 /* EasilyFrightened */] <0.5f
          ? (data[7 /* RespondsToCommands */] <0.5f
            ? (data[10 /* Noise1 */] <0.3829831f ? -0.20042814f : -0.19511971f)
            : -0.0384908f)
          : (data[5 /* StairsOutWindow */] <0.5f
            ? -0.14425808f
            : (data[9 /* Age */] != 2.0f ? -0.19771187f : -0.16344947f)))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
  // {01110000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {14, 0, 0, 0};
}


class GBMPojo_Forest_4 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_4_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_4_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.0662977f
          : (data[13 /* Noise4 */] <0.018522263f
            ? 0.08978581f
            : (data[9 /* Age */] != 9.0f ? 0.12788714f : 0.108413726f)))
        : 0.008178662f)
      : (data[3 /* TailLength */] <2.5f
        ? (data[12 /* Noise3 */] <0.48935533f ? 0.12913151f : 0.13674419f)
        : (data[2 /* HairLength */] <0.5f
          ? (data[6 /* HoursSpentNapping */] <4.0f
            ? 0.080327675f
            : (data[7 /* RespondsToCommands */] <0.5f ? -0.18317989f : -0.0636342f))
          : (data[8 /* EasilyFrightened */] <0.5f
            ? (data[3 /* TailLength */] <5.5f ? -0.012419769f : -0.18165492f)
            : (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */]) ? -0.18188013f : -0.16656671f)))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
  // {01100000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {6, 0, 0, 0};
}


class GBMPojo_Forest_5 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_5_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_5_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (data[3 /* TailLength */] <6.0f
          ? (data[9 /* Age */] != 16.0f
            ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */]) ? 0.124584004f : 0.13310453f)
            : (data[3 /* TailLength */] <3.5f ? 0.12445538f : 0.06326525f))
          : (data[13 /* Noise4 */] <0.13918766f
            ? 0.0048794686f
            : (data[14 /* Noise5 */] <0.86246854f ? 0.12581825f : 0.06367652f)))
        : 0.0073841065f)
      : (data[3 /* TailLength */] <2.5f
        ? (data[12 /* Noise3 */] <0.48935533f ? 0.12561573f : 0.13213703f)
        : (data[2 /* HairLength */] <0.5f
          ? (data[7 /* RespondsToCommands */] <0.5f ? -0.15075886f : 0.029351372f)
          : (data[8 /* EasilyFrightened */] <0.5f
            ? (data[3 /* TailLength */] <5.5f ? -0.011161304f : -0.16812322f)
            : (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */]) ? -0.16843085f : -0.1537713f)))));
    return pred;
  }
  // {10000000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {1, 0, 0, 0};
  // {01100000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {6, 0, 0, 0};
}


class GBMPojo_Forest_6 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_6_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_6_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[7 /* RespondsToCommands */] <0.5f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? -0.08568321f
          : (data[11 /* Noise2 */] <0.24012281f
            ? 0.059644982f
            : (data[12 /* Noise3 */] <0.24789679f ? 0.12822971f : 0.12175727f)))
        : (data[13 /* Noise4 */] <0.020468479f
          ? 0.07639909f
          : (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */])
            ? (data[9 /* Age */] != 9.0f ? 0.122095875f : 0.096696936f)
            : 0.12899657f)))
      : (data[3 /* TailLength */] <3.5f
        ? (!GenModel.bitSetContains(GRPSPLIT2, 0, (int) data[1 /* CoatColor */])
          ? (data[7 /* RespondsToCommands */] <0.5f ? -0.16734913f : 0.011883467f)
          : (data[10 /* Noise1 */] <0.52283317f ? 0.1284559f : 0.1424674f))
        : (data[8 /* EasilyFrightened */] <0.5f
          ? (data[7 /* RespondsToCommands */] <0.5f
            ? (!GenModel.bitSetContains(GRPSPLIT3, 0, (int) data[1 /* CoatColor */]) ? -0.16521631f : -0.15657645f)
            : -0.017907362f)
          : (data[5 /* StairsOutWindow */] <0.5f
            ? -0.10956819f
            : (data[2 /* HairLength */] <0.5f ? -0.18522003f : -0.1544296f)))));
    return pred;
  }
  // {01110000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {14, 0, 0, 0};
  // {10000000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {1, 0, 0, 0};
  // {01100000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT2 = new byte[] {6, 0, 0, 0};
  // {11011000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT3 = new byte[] {27, 0, 0, 0};
}


class GBMPojo_Forest_7 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_7_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_7_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.04761952f
          : (data[3 /* TailLength */] <6.0f
            ? (data[13 /* Noise4 */] <0.018522263f ? 0.12206428f : 0.11927856f)
            : (data[5 /* StairsOutWindow */] <0.5f ? 0.015137813f : 0.11992227f)))
        : -6.683607E-4f)
      : (data[3 /* TailLength */] <2.5f
        ? (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */]) ? 0.12156127f : 0.12639964f)
        : (data[2 /* HairLength */] <0.5f
          ? (data[6 /* HoursSpentNapping */] <4.0f
            ? 0.07968025f
            : (data[12 /* Noise3 */] <0.41605225f ? -0.033210553f : -0.16098514f))
          : (data[3 /* TailLength */] <5.5f
            ? (data[8 /* EasilyFrightened */] <0.5f ? -0.0044158464f : -0.13901666f)
            : (data[5 /* StairsOutWindow */] <0.5f ? -0.15329348f : -0.1478949f)))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
  // {00101000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {20, 0, 0, 0};
}


class GBMPojo_Forest_8 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_8_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_8_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[7 /* RespondsToCommands */] <0.5f
        ? (data[3 /* TailLength */] <4.5f
          ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
            ? (data[11 /* Noise2 */] <0.6153951f ? 0.11744301f : 0.116949886f)
            : 0.119415656f)
          : -0.06054368f)
        : (data[13 /* Noise4 */] <0.020468479f
          ? 0.06608348f
          : (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */])
            ? (data[9 /* Age */] != 9.0f ? 0.117515564f : 0.08843716f)
            : 0.12430207f)))
      : (data[3 /* TailLength */] <2.5f
        ? (data[12 /* Noise3 */] <0.48935533f ? 0.11850499f : 0.12310184f)
        : (data[2 /* HairLength */] <0.5f
          ? (data[7 /* RespondsToCommands */] <0.5f ? -0.12764303f : 0.03368761f)
          : (data[3 /* TailLength */] <5.5f
            ? (data[7 /* RespondsToCommands */] <0.5f ? -0.13796341f : -0.013923423f)
            : (data[8 /* EasilyFrightened */] <0.5f ? -0.14459726f : -0.1410996f)))));
    return pred;
  }
  // {10101000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {21, 0, 0, 0};
  // {10000000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {1, 0, 0, 0};
}


class GBMPojo_Forest_9 {
  public static void score0(double[] fdata, double[] preds) {
    preds[1] += GBMPojo_Tree_9_class_0.score0(fdata);
  }
}
class GBMPojo_Tree_9_class_0 {
  static final double score0(double[] data) {
    double pred =  (data[6 /* HoursSpentNapping */] <2.5f
      ? (data[3 /* TailLength */] != 6.0f
        ? (!GenModel.bitSetContains(GRPSPLIT0, 0, (int) data[1 /* CoatColor */])
          ? 0.03712984f
          : (data[3 /* TailLength */] != 8.0f
            ? (data[9 /* Age */] != 9.0f ? 0.11536301f : 0.08769692f)
            : 0.07374733f))
        : -0.0031505965f)
      : (data[3 /* TailLength */] <3.5f
        ? (!GenModel.bitSetContains(GRPSPLIT1, 0, (int) data[1 /* CoatColor */])
          ? (data[7 /* RespondsToCommands */] <0.5f ? -0.14522368f : 0.0061773616f)
          : (data[10 /* Noise1 */] <0.52283317f ? 0.121785514f : 0.13906747f))
        : (data[5 /* StairsOutWindow */] <0.5f
          ? -0.053801537f
          : (data[8 /* EasilyFrightened */] <0.5f
            ? (data[7 /* RespondsToCommands */] <0.5f ? -0.14157937f : -0.020405129f)
            : (data[2 /* HairLength */] <0.5f ? -0.16268885f : -0.1342171f)))));
    return pred;
  }
  // {01111000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT0 = new byte[] {30, 0, 0, 0};
  // {01100000 00000000 00000000 00000000}
  public static final byte[] GRPSPLIT1 = new byte[] {6, 0, 0, 0};
}



