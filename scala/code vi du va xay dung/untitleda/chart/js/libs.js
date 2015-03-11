/**
 * Created by tuanna on 5/6/14.
 */
function graphArea(id, data) {
    Morris.Area({
        element: id,
        data: data,
        xkey: 'x',
        ykeys: ['y', 'z'],
        labels: ['Y', 'Z']
    }).on('click', function (i, row) {
        console.log(i, row);
    });

}


function graphAreaLine(id, data) {
// Use Morris.Area instead of Morris.Line
    Morris.Area({
        element: id,
        behaveLikeLine: true,
        data: data,
        xkey: 'x',
        ykeys: ['y', 'z'],
        labels: ['Y', 'Z']
    });
}
function graphBar(id, data) {
// Use Morris.Bar
    Morris.Bar({
        element: id,
        data: data,
        xkey: 'x',
        ykeys: ['y', 'z', 'a'],
        labels: ['Y', 'Z', 'A']
    }).on('click', function (i, row) {
        console.log(i, row);
    });
}

function graphBarColor(id, data) {
// Use Morris.Bar
    Morris.Bar({
        element: id,
        data: data,
        xkey: 'x',
        ykeys: ['y'],
        labels: ['Y'],
        barColors: function (row, series, type) {
            if (type === 'bar') {
                var red = Math.ceil(255 * row.y / this.ymax);
                return 'rgb(' + red + ',0,0)';
            }
            else {
                return '#000';
            }
        }
    });

}

function graphBarNoAxes(id, data) {
// Use Morris.Bar
    Morris.Bar({
        element: id,
        axes: false,
        data: data,
        xkey: 'x',
        ykeys: ['y', 'z', 'a'],
        labels: ['Y', 'Z', 'A']
    });


}

function graphDays(id, data) {
    /* data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type */
    var day_data = data;
    Morris.Line({
        element: id,
        data: day_data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN']
    });


}

function graphDecimal(id, data) {

    window.m = Morris.Line({
        element: id,
        data: data,
        xkey: 'x',
        ykeys: ['y'],
        labels: ['sin(x)'],
        parseTime: false,
        hoverCallback: function (index, options, default_content) {
            var row = options.data[index];
            return default_content.replace("sin(x)", "1.5 + 1.5 sin(" + row.x + ")");
        },
        xLabelMargin: 10,
        integerYLabels: true
    });
}

function graphDiagonalXlabels(id, data) {
    Morris.Line({
        element: id,
        data: day_data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN'],
        xLabelAngle: 60
    });
}

function graphDXB(id, data) {
    Morris.Bar({
        element: id,
        data: day_data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN'],
        xLabelAngle: 60
    });
}

function graphDonut(id, data) {
    Morris.Donut({
        element: id,
        data: data,
        formatter: function (x) {
            return x + "%"
        }
    }).on('click', function (i, row) {
        console.log(i, row);
    });
}

function graphDonutColor(id, data) {
    Morris.Donut({
        element: id,
        data: data,
        backgroundColor: '#ccc',
        labelColor: '#060',
        colors: [
            '#0BA462',
            '#39B580',
            '#67C69D',
            '#95D7BB'
        ],
        formatter: function (x) {
            return x + "%"
        }
    });
}

function graphDonutFormat(id,data){
    Morris.Donut({
        element: id,
        data: data,
        formatter: function (x, data) { return data.formatted; }
    });


}

function graphEvent(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN'],
        events: [
            '2011-04',
            '2011-08'
        ]
    });
}

function graphGoals(id,data){
    window.m = Morris.Line({
        element: id,
        data: data,
        xkey: 'x',
        ykeys: ['y'],
        labels: ['sin(x)'],
        parseTime: false,
        goals: [-1, 0, 1]
    });

}

function graphMonth(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN'],
        smooth: false
    });
}

function graphNegative(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['a'],
        labels: ['Series A'],
        units: '%'
    });
}

function graphNoGrid(id,data){
    Morris.Line({
        element: id,
        grid: false,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN']
    });

}

function graphNonCtn(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned', 'other'],
        labels: ['Licensed', 'SORN', 'Other'],
        /* custom label formatting with `xLabelFormat` */
        xLabelFormat: function(d) { return (d.getMonth()+1)+'/'+d.getDate()+'/'+d.getFullYear(); },
        /* setting `xLabels` is recommended when using xLabelFormat */
        xLabels: 'day'
    });

}

function graphNonDate(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'elapsed',
        ykeys: ['value'],
        labels: ['value'],
        parseTime: false
    });

}

function graphQuaters(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN']
    });
}

function graphStack(id,data){
    Morris.Bar({
        element: id,
        data: data ,
        xkey: 'x',
        ykeys: ['y', 'z', 'a'],
        labels: ['Y', 'Z', 'A'],
        stacked: true
    });
}


function graphTimestamps(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN'],
        dateFormat: function (x) { return new Date(x).toDateString(); }
    });
}


function graphUpdate(id){
    var nReloads = 0;
    function data(offset) {
        var ret = [];
        for (var x = 0; x <= 360; x += 10) {
            var v = (offset + x) % 360;
            ret.push({
                x: x,
                y: Math.sin(Math.PI * v / 180).toFixed(4),
                z: Math.cos(Math.PI * v / 180).toFixed(4)
            });
        }
        return ret;
    }
    var graph = Morris.Line({
        element: id,
        data: data(0),
        xkey: 'x',
        ykeys: ['y', 'z'],
        labels: ['sin()', 'cos()'],
        parseTime: false,
        ymin: -1.0,
        ymax: 1.0,
        hideHover: true
    });
    function update() {
        nReloads++;
        graph.setData(data(5 * nReloads));
        $('#reloadStatus').text(nReloads + ' reloads');
    }
    setInterval(update, 100);

}

function graphWeek(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN']
    });
}

function graphYear(id,data){
    Morris.Line({
        element: id,
        data: data,
        xkey: 'period',
        ykeys: ['licensed', 'sorned'],
        labels: ['Licensed', 'SORN']
    });
}