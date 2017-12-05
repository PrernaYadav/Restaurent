package mycollege.asmobisoft.com.restaurentapp.Navigationnn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import mycollege.asmobisoft.com.restaurentapp.Adaptor.ChatAdapter;
import mycollege.asmobisoft.com.restaurentapp.R;
import mycollege.asmobisoft.com.restaurentapp.activity.ChatMessege;

public class SupportFragment extends Fragment {

   /* public SupportFragment() {
        // Required empty public constructor initControls();
    }*/
   private EditText messageET;
    private ListView messagesContainer;
    private ImageButton sendBtn;
    private ChatAdapter adapter;
    private ArrayList<ChatMessege> chatHistory;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_chatpage, container, false);







        messagesContainer = (ListView)rootView.findViewById(R.id.messagesContainer1);
        messageET = (EditText) rootView.findViewById(R.id.messageEdit);
        sendBtn = (ImageButton) rootView.findViewById(R.id.chatSendButton);

        TextView meLabel = (TextView)rootView. findViewById(R.id.meLbl);
        TextView companionLabel = (TextView)rootView. findViewById(R.id.friendLabel);
        RelativeLayout container1 = (RelativeLayout)rootView. findViewById(R.id.container);
        companionLabel.setText("Me");// Hard Coded
        loadDummyHistory();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageET.getText().toString();
                if (TextUtils.isEmpty(messageText)) {
                    return;
                }

                ChatMessege chatMessage = new ChatMessege();
                chatMessage.setId(122);//dummy
                chatMessage.setMessage(messageText);
                chatMessage.setDate(DateFormat.getDateTimeInstance().format(new Date()));
                chatMessage.setMe(true);

                messageET.setText("");

                displayMessage(chatMessage);

                }

        });
        return rootView;
    }

    public void displayMessage(ChatMessege messege) {
        adapter.add(messege);
        adapter.notifyDataSetChanged();
        scroll();
    }

    private void scroll() {
        messagesContainer.setSelection(messagesContainer.getCount() - 1);
    }

    private void loadDummyHistory(){

        chatHistory = new ArrayList<ChatMessege>();

        ChatMessege msg = new ChatMessege();
        msg.setId(1);
        msg.setMe(false);
        msg.setMessage("Hi");
        msg.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistory.add(msg);
        ChatMessege msg1 = new ChatMessege();
        msg1.setId(2);
        msg1.setMe(false);
        msg1.setMessage("How r u doing???");
        msg1.setDate(DateFormat.getDateTimeInstance().format(new Date()));
        chatHistory.add(msg1);

        adapter = new ChatAdapter(getActivity(), new ArrayList<ChatMessege>());
        messagesContainer.setAdapter(adapter);

        for(int i=0; i<chatHistory.size(); i++) {
            ChatMessege message = chatHistory.get(i);
            displayMessage(message);
             // Inflate the layout for this fragment



}}
}

