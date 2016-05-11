package protocolsupport.protocol.packet.middleimpl.serverbound.login.v_1_7_1_8;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.serverbound.login.MiddleLoginStart;
import protocolsupport.protocol.serializer.PacketDataSerializer;

public class LoginStart extends MiddleLoginStart {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		name = serializer.readString(16);
	}

}
