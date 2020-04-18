<label for="instansi">Agent involved</label><br>
                      
                      <select id="instansi" name="instansi" required onchange="add_element_to_array(); display_array()" >
                      <option disabled selected> Select </option>
                      <?php
                              $query = pg_query("SELECT * FROM instansi");
                              while ($row = pg_fetch_assoc($query)) {
                          ?>
                          <option value="<?=$row['nama_instansi']?>" ><?=$row['nama_instansi']?></option>

                        <?php
                          }
                        ?>
                          <option>-- Add new --</option>
                    </select>
                    <button type="button" class="btn btn-info" data-toggle='modal'  data-target='#show'> + Enter agent data</button>
                      
                    <div id="Result"><?=$row['nama_instansi']?></div>  
                    <script>
                      var x = 0;
                      var array = Array();

                      function add_element_to_array()
                      {
                      array[x] = document.getElementById("instansi").value;
                      alert("Element: " + array[x] + " Added at index " + x);
                      x++;
                      document.getElementById("instansi").value = "";
                      }

                      function display_array()
                      {
                        var e = "";   
                          
                        for (var y=0; y<array.length; y++)
                        {
                          e += array[y] + "<br/>";
                        }
                        document.getElementById("Result").innerHTML = e;
                      }
                      </script>