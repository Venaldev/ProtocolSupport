package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_6_1_7_1_8;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.serverbound.play.MiddlePlayerAbilities;
import protocolsupport.protocol.serializer.PacketDataSerializer;

public class PlayerAbilities extends MiddlePlayerAbilities {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		flags = serializer.readUnsignedByte();
		flySpeed = serializer.readFloat();
		walkSpeed = serializer.readFloat();
	}

}
