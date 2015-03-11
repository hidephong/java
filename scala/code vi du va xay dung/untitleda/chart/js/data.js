/**
 * Created by tuanna on 5/6/14.
 */
var dataArea = [
    {x: '2011 Q1', y: 3, z: 3},
    {x: '2011 Q2', y: 2, z: 0},
    {x: '2011 Q3', y: 2, z: 5},
    {x: '2011 Q4', y: 4, z: 4}
]


var dataDays = [
    {"period": "2012-10-01", "licensed": 3407, "sorned": 660},
    {"period": "2012-09-30", "licensed": 3351, "sorned": 629},
    {"period": "2012-09-29", "licensed": 3269, "sorned": 618},
    {"period": "2012-09-20", "licensed": 3246, "sorned": 661},
    {"period": "2012-09-19", "licensed": 3257, "sorned": 667},
    {"period": "2012-09-18", "licensed": 3248, "sorned": 627},
    {"period": "2012-09-17", "licensed": 3171, "sorned": 660},
    {"period": "2012-09-16", "licensed": 3171, "sorned": 676},
    {"period": "2012-09-15", "licensed": 3201, "sorned": 656},
    {"period": "2012-09-10", "licensed": 3215, "sorned": 622}
];
var dataAreaLine = [
    {x: '2011 Q1', y: 3, z: 3},
    {x: '2011 Q2', y: 2, z: 1},
    {x: '2011 Q3', y: 2, z: 4},
    {x: '2011 Q4', y: 3, z: 3}
]

var databar = [
    {x: '2011 Q1', y: 3, z: 2, a: 3},
    {x: '2011 Q2', y: 2, z: null, a: 1},
    {x: '2011 Q3', y: 0, z: 2, a: 4},
    {x: '2011 Q4', y: 2, z: 4, a: 3}
]

var dataBarColor = [
    {x: '2011 Q1', y: 0},
    {x: '2011 Q2', y: 1},
    {x: '2011 Q3', y: 2},
    {x: '2011 Q4', y: 3},
    {x: '2012 Q1', y: 4},
    {x: '2012 Q2', y: 5},
    {x: '2012 Q3', y: 6},
    {x: '2012 Q4', y: 7},
    {x: '2013 Q1', y: 8}
]

var dataBarNoAxes =  [
    {x: '2011 Q1', y: 3, z: 2, a: 3},
    {x: '2011 Q2', y: 2, z: null, a: 1},
    {x: '2011 Q3', y: 0, z: 2, a: 4},
    {x: '2011 Q4', y: 2, z: 4, a: 3}
]

var decimal_data = [];
for (var x = 0; x <= 360; x += 10) {
    decimal_data.push({
        x: x,
        y: 1.5 + 1.5 * Math.sin(Math.PI * x / 180).toFixed(4)
    });
}

var day_data = [
    {"period": "2012-10-30", "licensed": 3407, "sorned": 660},
    {"period": "2012-09-30", "licensed": 3351, "sorned": 629},
    {"period": "2012-09-29", "licensed": 3269, "sorned": 618},
    {"period": "2012-09-20", "licensed": 3246, "sorned": 661},
    {"period": "2012-09-19", "licensed": 3257, "sorned": 667},
    {"period": "2012-09-18", "licensed": 3248, "sorned": 627},
    {"period": "2012-09-17", "licensed": 3171, "sorned": 660},
    {"period": "2012-09-16", "licensed": 3171, "sorned": 676},
    {"period": "2012-09-15", "licensed": 3201, "sorned": 656},
    {"period": "2012-09-10", "licensed": 3215, "sorned": 622}
];

var data_donut = [
    {value: 70, label: 'foo'},
    {value: 15, label: 'bar'},
    {value: 10, label: 'baz'},
    {value: 5, label: 'A really really long label'}
]

var data_format = [
    {value: 70, label: 'foo', formatted: 'at least 70%' },
    {value: 15, label: 'bar', formatted: 'approx. 15%' },
    {value: 10, label: 'baz', formatted: 'approx. 10%' },
    {value: 5, label: 'A really really long label', formatted: 'at most 5%' }
]

var week_data = [
    {"period": "2011 W27", "licensed": 3407, "sorned": 660},
    {"period": "2011 W26", "licensed": 3351, "sorned": 629},
    {"period": "2011 W25", "licensed": 3269, "sorned": 618},
    {"period": "2011 W24", "licensed": 3246, "sorned": 661},
    {"period": "2011 W23", "licensed": 3257, "sorned": 667},
    {"period": "2011 W22", "licensed": 3248, "sorned": 627},
    {"period": "2011 W21", "licensed": 3171, "sorned": 660},
    {"period": "2011 W20", "licensed": 3171, "sorned": 676},
    {"period": "2011 W19", "licensed": 3201, "sorned": 656},
    {"period": "2011 W18", "licensed": 3215, "sorned": 622},
    {"period": "2011 W17", "licensed": 3148, "sorned": 632},
    {"period": "2011 W16", "licensed": 3155, "sorned": 681},
    {"period": "2011 W15", "licensed": 3190, "sorned": 667},
    {"period": "2011 W14", "licensed": 3226, "sorned": 620},
    {"period": "2011 W13", "licensed": 3245, "sorned": null},
    {"period": "2011 W12", "licensed": 3289, "sorned": null},
    {"period": "2011 W11", "licensed": 3263, "sorned": null},
    {"period": "2011 W10", "licensed": 3189, "sorned": null},
    {"period": "2011 W09", "licensed": 3079, "sorned": null},
    {"period": "2011 W08", "licensed": 3085, "sorned": null},
    {"period": "2011 W07", "licensed": 3055, "sorned": null},
    {"period": "2011 W06", "licensed": 3063, "sorned": null},
    {"period": "2011 W05", "licensed": 2943, "sorned": null},
    {"period": "2011 W04", "licensed": 2806, "sorned": null},
    {"period": "2011 W03", "licensed": 2674, "sorned": null},
    {"period": "2011 W02", "licensed": 1702, "sorned": null},
    {"period": "2011 W01", "licensed": 1732, "sorned": null}
];

var dec_goals_data = [];
for (var x = 0; x <= 360; x += 10) {
    dec_goals_data.push({
        x: x,
        y: Math.sin(Math.PI * x / 180).toFixed(4)
    });
}

var month_data = [
    {"period": "2012-10", "licensed": 3407, "sorned": 660},
    {"period": "2011-08", "licensed": 3351, "sorned": 629},
    {"period": "2011-03", "licensed": 3269, "sorned": 618},
    {"period": "2010-08", "licensed": 3246, "sorned": 661},
    {"period": "2010-05", "licensed": 3257, "sorned": 667},
    {"period": "2010-03", "licensed": 3248, "sorned": 627},
    {"period": "2010-01", "licensed": 3171, "sorned": 660},
    {"period": "2009-12", "licensed": 3171, "sorned": 676},
    {"period": "2009-10", "licensed": 3201, "sorned": 656},
    {"period": "2009-09", "licensed": 3215, "sorned": 622}
];

var neg_data = [
    {"period": "2011-08-12", "a": 100},
    {"period": "2011-03-03", "a": 75},
    {"period": "2010-08-08", "a": 50},
    {"period": "2010-05-10", "a": 25},
    {"period": "2010-03-14", "a": 0},
    {"period": "2010-01-10", "a": -25},
    {"period": "2009-12-10", "a": -50},
    {"period": "2009-10-07", "a": -75},
    {"period": "2009-09-25", "a": -100}
];


var nc_data = [
    {"period": "2012-10-01", "licensed": 3407},
    {"period": "2012-09-30", "sorned": 0},
    {"period": "2012-09-29", "sorned": 618},
    {"period": "2012-09-20", "licensed": 3246, "sorned": 661},
    {"period": "2012-09-19", "licensed": 3257, "sorned": null},
    {"period": "2012-09-18", "licensed": 3248, "other": 1000},
    {"period": "2012-09-17", "sorned": 0},
    {"period": "2012-09-16", "sorned": 0},
    {"period": "2012-09-15", "licensed": 3201, "sorned": 656},
    {"period": "2012-09-10", "licensed": 3215}
];

var date_data = [
    {"elapsed": "I", "value": 34},
    {"elapsed": "II", "value": 24},
    {"elapsed": "III", "value": 3},
    {"elapsed": "IV", "value": 12},
    {"elapsed": "V", "value": 13},
    {"elapsed": "VI", "value": 22},
    {"elapsed": "VII", "value": 5},
    {"elapsed": "VIII", "value": 26},
    {"elapsed": "IX", "value": 12},
    {"elapsed": "X", "value": 19}
];

var quarter_data = [
    {"period": "2011 Q3", "licensed": 3407, "sorned": 660},
    {"period": "2011 Q2", "licensed": 3351, "sorned": 629},
    {"period": "2011 Q1", "licensed": 3269, "sorned": 618},
    {"period": "2010 Q4", "licensed": 3246, "sorned": 661},
    {"period": "2010 Q3", "licensed": 3257, "sorned": 667},
    {"period": "2010 Q2", "licensed": 3248, "sorned": 627},
    {"period": "2010 Q1", "licensed": 3171, "sorned": 660},
    {"period": "2009 Q4", "licensed": 3171, "sorned": 676},
    {"period": "2009 Q3", "licensed": 3201, "sorned": 656},
    {"period": "2009 Q2", "licensed": 3215, "sorned": 622},
    {"period": "2009 Q1", "licensed": 3148, "sorned": 632},
    {"period": "2008 Q4", "licensed": 3155, "sorned": 681},
    {"period": "2008 Q3", "licensed": 3190, "sorned": 667},
    {"period": "2007 Q4", "licensed": 3226, "sorned": 620},
    {"period": "2006 Q4", "licensed": 3245, "sorned": null},
    {"period": "2005 Q4", "licensed": 3289, "sorned": null},
    {"period": "2004 Q4", "licensed": 3263, "sorned": null},
    {"period": "2003 Q4", "licensed": 3189, "sorned": null},
    {"period": "2002 Q4", "licensed": 3079, "sorned": null},
    {"period": "2001 Q4", "licensed": 3085, "sorned": null},
    {"period": "2000 Q4", "licensed": 3055, "sorned": null},
    {"period": "1999 Q4", "licensed": 3063, "sorned": null},
    {"period": "1998 Q4", "licensed": 2943, "sorned": null},
    {"period": "1997 Q4", "licensed": 2806, "sorned": null},
    {"period": "1996 Q4", "licensed": 2674, "sorned": null},
    {"period": "1995 Q4", "licensed": 1702, "sorned": null},
    {"period": "1994 Q4", "licensed": 1732, "sorned": null}
];

var stack_data = [
    {x: '2011 Q1', y: 3, z: 2, a: 3},
    {x: '2011 Q2', y: 2, z: null, a: 1},
    {x: '2011 Q3', y: 0, z: 2, a: 4},
    {x: '2011 Q4', y: 2, z: 4, a: 3}
]

var timestamp_data = [
    {"period": 1349046000000, "licensed": 3407, "sorned": 660},
    {"period": 1313103600000, "licensed": 3351, "sorned": 629},
    {"period": 1299110400000, "licensed": 3269, "sorned": 618},
    {"period": 1281222000000, "licensed": 3246, "sorned": 661},
    {"period": 1273446000000, "licensed": 3257, "sorned": 667},
    {"period": 1268524800000, "licensed": 3248, "sorned": 627},
    {"period": 1263081600000, "licensed": 3171, "sorned": 660},
    {"period": 1260403200000, "licensed": 3171, "sorned": 676},
    {"period": 1254870000000, "licensed": 3201, "sorned": 656},
    {"period": 1253833200000, "licensed": 3215, "sorned": 622}
];


var year_data = [
    {"period": "2012", "licensed": 3407, "sorned": 660},
    {"period": "2011", "licensed": 3351, "sorned": 629},
    {"period": "2010", "licensed": 3269, "sorned": 618},
    {"period": "2009", "licensed": 3246, "sorned": 661},
    {"period": "2008", "licensed": 3257, "sorned": 667},
    {"period": "2007", "licensed": 3248, "sorned": 627},
    {"period": "2006", "licensed": 3171, "sorned": 660},
    {"period": "2005", "licensed": 3171, "sorned": 676},
    {"period": "2004", "licensed": 3201, "sorned": 656},
    {"period": "2003", "licensed": 3215, "sorned": 622}
];