</br></br>
<form class="form-horizontal"
      action="j_security_check"
      method="post">
    <div class="form-group ">
        <label for="userName" class="col-sm-2 col-sm-offset-3 control-label">User Name</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" name="j_username" id="userName">
        </div>
    </div>
    <div class="form-group">
        <label for="password" class="col-sm-2 col-sm-offset-3 control-label">Password</label>
        <div class="col-sm-2">
            <input type="password" class="form-control" name="j_password" id="password" >
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-5 col-sm-2">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>