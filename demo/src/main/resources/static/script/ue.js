$("#table_UE").dataTable().fnDestroy();
$.ajax({
    type:"GET",
    url:"http://localhost:8084/maquette/ue",
    dataType:'json',
    success:function(data) {
        $('#table_UE').dataTable({
            data: data,
            columns :[
                { data: 'code'},
                { data: 'libelle'},
                { data: 'credit'},
                { data: 'coefficient'},
                {
                    data: null,
                    render : function(data, type,full,meta)
                    {
                        return "<button class='btn btn-info btn-sm' onclick='modifier_UE("+data.id+")'>Modifier</button>" +
                        "<button class='btn btn-danger btn-sm' onclick='supprimer_UE("+data.id+")'>Supprimer</button>" ;                       
                    }

                },
                {
                    data: null,
                    render : function(data, type,full,meta)
                    {
                        return "<a class='btn btn-primary btn-sm' href='details_ue.html'>Voir</a>";                       
                    }

                }

            ],
            fnCreatedRow : function( nRow, data,iDataIndex){
                $(nRow).attr('id', "ligne"+data.id);
            },

        });
    }
});

$("#btn_Ajouter_UE").click( function(){
    code = $('#inpt_Ajt_UE_Code').val();
    Libelle = $('#inpt_Ajt_UE_Libelle').val();
    credit = $('#inpt_Ajt_UE_Credit').val();
    coefficient = $('#inpt_Ajt_UE_Coefficient').val();
    ue = { code : code , Libelle:Libelle , credit : credit, coefficient:coefficient };
    $.ajax({
        type:"POST",
        url:"http://localhost:8084/maquette/ue",
        data:json.stringify(ue),
        contentType: "application/json",
        success:function(data){
            var u =data;
            var Ligne = "<tr id='Ligne"+u.id+"' >" + 
            "<td>"+u.code+"</td>"+
            "<td>"+u.Libelle+"</td>"+
            "<td>"+u.credit+"</td>"+
            "<td>"+u.coefficient+"</td>"+
            "<td>"+
            "<button class='btn btn-info btn-sm' onclick='modifier_UE("+u.id+")'>Modifier</button>" +
            "<button class='btn btn-danger btn-sm' onclick='supprimer_UE("+u.id+")'>Supprimer</button>" +

            "</td>"+
            "<td>"+
                "<a class='btn btn-primary btn-sm' href='details_ue.html'>Voir </a> "
            "</td>"+
            "</tr>";
            $("#table_UE").prepend(Ligne);
            $('#inpt_Ajt_UE_Code').val("");
            $('#inpt_Ajt_UE_Libelle').val("");
            $('#inpt_Ajt_UE_Credit').val("");
            $('#inpt_Ajt_UE_Coefficient').val("");
            $('#inpt_Ajt_UE').modal('hide');

        }
        
    });
});