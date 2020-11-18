<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.tableFixHead          { overflow-y: auto; height: 100px; }
.tableFixHead thead th { position: sticky; top: 0; }

/* Just common table stuff. Really. */
table  { border-collapse: collapse; width: 100%; }
th, td { padding: 8px 16px; }
th     { background:#eee; }
</style>
</head>
<body>
<div id="theVictim">
                      <div class="col-sm-7">
                      <select id="korban" name="korban[]" class="form-control" multiple="multiple">
                        
                             
                              <option  value="" required>1</option>
                              <option  value="" required>2</option>
                              
                              
                      </select>
                      </div>
                      <div class="col-sm-5">
                      <select id="kondisi" name="kondisi[]" class="form-control" multiple="multiple">
                        
                      <option  value="" required>1</option>
                              <option  value="" required>2</option>
                      </select> 
                      </div>
                   </div>
                   
                   <button id="add_btn" onclick="addRow()">Add new row</button>
                   <script>
                    function addRow(){
                        var parentTable = document.getElementById('theVIctim');
                        var tableRow = document.getElementsByTagName('select')[0].children;
                        var unitTables = document.getElementsById('korban')[0];
                        var newInputType = document.createElement('select');
                        // newInputType.setAttribute('type', 'text');
                        
                        for(var i=0; i<unitTables.children.length; i++){
                          var appendedInput = unitTables.children[i].appendChild(newInputType)
                          parentTable.appendChild(appendedInput);
                        }
                      }

                    </script>


</body>
</html>
<script src="../assets/js/jquery-1.10.2.js"></script>
    <script src="../assets/js/bootstrap.js"></script>