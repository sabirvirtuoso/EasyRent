<fieldset>
    <div class="input_fields_wrap">
        <section>
            <label><b>Upload your image (800 KB, .jpeg only) (Mandatory)</b></label>
            <input id="one" type="file" name="pictureOne" onchange="readURL(this);">
            <img id="blahone" src="/EasyRent/resources/assets/img/user.jpg" alt="your image" />
        </section>
        <section style="display:none">
            <label><b>Upload your image (800 KB, .jpeg only) (Optional)</b></label>
            <input id="two" type="file" name="pictureTwo" onchange="readURL(this);">
            <img id="blahtwo" src="/EasyRent/resources/assets/img/user.jpg" alt="your image" />
        </section>
        <section style="display:none">
            <label><b>Upload your image (800 KB, .jpeg only) (Optional)</b></label>
            <input id="three" type="file" name="pictureThree" onchange="readURL(this);">
            <img id="blahthree" src="/EasyRent/resources/assets/img/user.jpg" alt="your image" />
        </section>
        <button style="display:none" id="add_field_button" class="btn btn-success">Add More Images (Max 3)</button>
    </div>
</fieldset>

<fieldset class="gllpLatlonPicker">
    <label><b>Drag the marker to your desired address</b></label>
    <br/><br/>
    <div class="gllpMap">Google Maps</div>
    <br/>
    <label>Latitude</label>
    <sf:input path="latitude" cssClass="gllpLatitude" value="23.816318182292207"/>
    <label>Longitude</label>
    <sf:input path="longitude" cssClass="gllpLongitude" value="90.411376953125"/>
    <br/>
</fieldset>