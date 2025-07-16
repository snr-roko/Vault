package com.rokoinc.Vault.exchange;

public enum Currency {
    AED, AFN, ALL, AMD, ANG, AOA, ARS, AUD, AWG, AZN,
    BAM, BBD, BDT, BGN, BHD, BIF, BMD, BND, BOB, BRL, BSD, BTN, BWP, BYN, BZD,
    CAD, CDF, CHF, CLP, CNY, COP, CRC, CUP, CVE, CZK,
    DJF, DKK, DOP, DZD,
    EGP, ERN, ETB, EUR,
    FJD, FKP, FOK,
    GBP, GEL, GGP, GHS, GIP, GMD, GNF, GTQ, GYD,
    HKD, HNL, HRK, HTG, HUF,
    IDR, ILS, IMP, INR, IQD, IRR, ISK,
    JEP, JMD, JOD, JPY,
    KES, KGS, KHR, KID, KMF, KRW, KWD, KYD, KZT,
    LAK, LBP, LKR, LRD, LSL, LYD,
    MAD, MDL, MGA, MKD, MMK, MNT, MOP, MRU, MUR, MVR, MWK, MXN, MYR, MZN,
    NAD, NGN, NIO, NOK, NPR, NZD,
    OMR,
    PAB, PEN, PGK, PHP, PKR, PLN, PYG,
    QAR,
    RON, RSD, RUB, RWF,
    SAR, SBD, SCR, SDG, SEK, SGD, SHP, SLE, SOS, SRD, SSP, STN, SYP, SZL,
    THB, TJS, TMT, TND, TOP, TRY, TTD, TVD, TWD, TZS,
    UAH, UGX, USD, UYU, UZS,
    VES, VND, VUV,
    WST,
    XAF, XCD, XDR, XOF, XPF,
    YER,
    ZAR, ZMW, ZWL;

    public String getDisplayName() {
        return switch (this) {
            case AED -> "UAE Dirham";
            case AFN -> "Afghan Afghani";
            case ALL -> "Albanian Lek";
            case AMD -> "Armenian Dram";
            case ANG -> "Netherlands Antillian Guilder";
            case AOA -> "Angolan Kwanza";
            case ARS -> "Argentine Peso";
            case AUD -> "Australian Dollar";
            case AWG -> "Aruban Florin";
            case AZN -> "Azerbaijani Manat";
            case BAM -> "Bosnia and Herzegovina Mark";
            case BBD -> "Barbados Dollar";
            case BDT -> "Bangladeshi Taka";
            case BGN -> "Bulgarian Lev";
            case BHD -> "Bahraini Dinar";
            case BIF -> "Burundian Franc";
            case BMD -> "Bermudian Dollar";
            case BND -> "Brunei Dollar";
            case BOB -> "Bolivian Boliviano";
            case BRL -> "Brazilian Real";
            case BSD -> "Bahamian Dollar";
            case BTN -> "Bhutanese Ngultrum";
            case BWP -> "Botswana Pula";
            case BYN -> "Belarusian Ruble";
            case BZD -> "Belize Dollar";
            case CAD -> "Canadian Dollar";
            case CDF -> "Congolese Franc";
            case CHF -> "Swiss Franc";
            case CLP -> "Chilean Peso";
            case CNY -> "Chinese Renminbi";
            case COP -> "Colombian Peso";
            case CRC -> "Costa Rican Colon";
            case CUP -> "Cuban Peso";
            case CVE -> "Cape Verdean Escudo";
            case CZK -> "Czech Koruna";
            case DJF -> "Djiboutian Franc";
            case DKK -> "Danish Krone";
            case DOP -> "Dominican Peso";
            case DZD -> "Algerian Dinar";
            case EGP -> "Egyptian Pound";
            case ERN -> "Eritrean Nakfa";
            case ETB -> "Ethiopian Birr";
            case EUR -> "Euro";
            case FJD -> "Fiji Dollar";
            case FKP -> "Falkland Islands Pound";
            case FOK -> "Faroese Króna";
            case GBP -> "Pound Sterling";
            case GEL -> "Georgian Lari";
            case GGP -> "Guernsey Pound";
            case GHS -> "Ghanaian Cedi";
            case GIP -> "Gibraltar Pound";
            case GMD -> "Gambian Dalasi";
            case GNF -> "Guinean Franc";
            case GTQ -> "Guatemalan Quetzal";
            case GYD -> "Guyanese Dollar";
            case HKD -> "Hong Kong Dollar";
            case HNL -> "Honduran Lempira";
            case HRK -> "Croatian Kuna";
            case HTG -> "Haitian Gourde";
            case HUF -> "Hungarian Forint";
            case IDR -> "Indonesian Rupiah";
            case ILS -> "Israeli New Shekel";
            case IMP -> "Manx Pound";
            case INR -> "Indian Rupee";
            case IQD -> "Iraqi Dinar";
            case IRR -> "Iranian Rial";
            case ISK -> "Icelandic Króna";
            case JEP -> "Jersey Pound";
            case JMD -> "Jamaican Dollar";
            case JOD -> "Jordanian Dinar";
            case JPY -> "Japanese Yen";
            case KES -> "Kenyan Shilling";
            case KGS -> "Kyrgyzstani Som";
            case KHR -> "Cambodian Riel";
            case KID -> "Kiribati Dollar";
            case KMF -> "Comorian Franc";
            case KRW -> "South Korean Won";
            case KWD -> "Kuwaiti Dinar";
            case KYD -> "Cayman Islands Dollar";
            case KZT -> "Kazakhstani Tenge";
            case LAK -> "Lao Kip";
            case LBP -> "Lebanese Pound";
            case LKR -> "Sri Lanka Rupee";
            case LRD -> "Liberian Dollar";
            case LSL -> "Lesotho Loti";
            case LYD -> "Libyan Dinar";
            case MAD -> "Moroccan Dirham";
            case MDL -> "Moldovan Leu";
            case MGA -> "Malagasy Ariary";
            case MKD -> "Macedonian Denar";
            case MMK -> "Burmese Kyat";
            case MNT -> "Mongolian Tögrög";
            case MOP -> "Macanese Pataca";
            case MRU -> "Mauritanian Ouguiya";
            case MUR -> "Mauritian Rupee";
            case MVR -> "Maldivian Rufiyaa";
            case MWK -> "Malawian Kwacha";
            case MXN -> "Mexican Peso";
            case MYR -> "Malaysian Ringgit";
            case MZN -> "Mozambican Metical";
            case NAD -> "Namibian Dollar";
            case NGN -> "Nigerian Naira";
            case NIO -> "Nicaraguan Córdoba";
            case NOK -> "Norwegian Krone";
            case NPR -> "Nepalese Rupee";
            case NZD -> "New Zealand Dollar";
            case OMR -> "Omani Rial";
            case PAB -> "Panamanian Balboa";
            case PEN -> "Peruvian Sol";
            case PGK -> "Papua New Guinean Kina";
            case PHP -> "Philippine Peso";
            case PKR -> "Pakistani Rupee";
            case PLN -> "Polish Złoty";
            case PYG -> "Paraguayan Guaraní";
            case QAR -> "Qatari Riyal";
            case RON -> "Romanian Leu";
            case RSD -> "Serbian Dinar";
            case RUB -> "Russian Ruble";
            case RWF -> "Rwandan Franc";
            case SAR -> "Saudi Riyal";
            case SBD -> "Solomon Islands Dollar";
            case SCR -> "Seychellois Rupee";
            case SDG -> "Sudanese Pound";
            case SEK -> "Swedish Krona";
            case SGD -> "Singapore Dollar";
            case SHP -> "Saint Helena Pound";
            case SLE -> "Sierra Leonean Leone";
            case SOS -> "Somali Shilling";
            case SRD -> "Surinamese Dollar";
            case SSP -> "South Sudanese Pound";
            case STN -> "São Tomé and Príncipe Dobra";
            case SYP -> "Syrian Pound";
            case SZL -> "Eswatini Lilangeni";
            case THB -> "Thai Baht";
            case TJS -> "Tajikistani Somoni";
            case TMT -> "Turkmenistan Manat";
            case TND -> "Tunisian Dinar";
            case TOP -> "Tongan Paʻanga";
            case TRY -> "Turkish Lira";
            case TTD -> "Trinidad and Tobago Dollar";
            case TVD -> "Tuvaluan Dollar";
            case TWD -> "New Taiwan Dollar";
            case TZS -> "Tanzanian Shilling";
            case UAH -> "Ukrainian Hryvnia";
            case UGX -> "Ugandan Shilling";
            case USD -> "United States Dollar";
            case UYU -> "Uruguayan Peso";
            case UZS -> "Uzbekistani So'm";
            case VES -> "Venezuelan Bolívar Soberano";
            case VND -> "Vietnamese Đồng";
            case VUV -> "Vanuatu Vatu";
            case WST -> "Samoan Tālā";
            case XAF -> "Central African CFA Franc";
            case XCD -> "East Caribbean Dollar";
            case XDR -> "Special Drawing Rights";
            case XOF -> "West African CFA franc";
            case XPF -> "CFP Franc";
            case YER -> "Yemeni Rial";
            case ZAR -> "South African Rand";
            case ZMW -> "Zambian Kwacha";
            case ZWL -> "Zimbabwean Dollar";
        };
    }

}
