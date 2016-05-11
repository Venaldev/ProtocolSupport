package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_1_8;

import java.io.IOException;

import protocolsupport.protocol.packet.middle.serverbound.play.MiddleCustomPayload;
import protocolsupport.protocol.serializer.PacketDataSerializer;
import protocolsupport.utils.netty.ChannelUtils;

public class CustomPayload extends MiddleCustomPayload {

	@Override
	public void readFromClientData(PacketDataSerializer serializer) throws IOException {
		tag = serializer.readString(20);
		data = ChannelUtils.toArray(serializer);
	}

}
