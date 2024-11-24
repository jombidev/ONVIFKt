package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifResponseListener;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifType;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Created by Luke F on 07/08/2020.
 */
@Getter
@NoArgsConstructor
public class GotoHomePositionRequest implements OnvifRequest {

    //Constants
    public static final String TAG = GotoHomePositionRequest.class.getSimpleName();

    //Attributes
    private OnvifResponseListener listener;
    private OnvifMediaProfile mediaProfile;

    //Constructors
    public GotoHomePositionRequest(OnvifMediaProfile mediaProfile) {
        this.mediaProfile = mediaProfile;
    }

    public GotoHomePositionRequest(OnvifMediaProfile mediaProfile, OnvifResponseListener listener) {
        super();
        this.mediaProfile = mediaProfile;
        this.listener = listener;
    }

    //Properties

    @Override
    public String getXml() {
        return "<GotoHomePosition xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" +
                "<ProfileToken>" + mediaProfile.getToken() + "</ProfileToken>" +
                "</GotoHomePosition>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.GOTO_HOME_POSITION;
    }

}
