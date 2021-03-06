package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_8;

import io.netty.buffer.ByteBuf;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleBlockPlace;
import protocolsupport.protocol.serializer.ItemStackSerializer;
import protocolsupport.protocol.serializer.PositionSerializer;

public class BlockPlace extends MiddleBlockPlace {

	@Override
	public void readFromClientData(ByteBuf clientdata, ProtocolVersion version) {
		position = PositionSerializer.readPosition(clientdata);
		face = clientdata.readByte();
		ItemStackSerializer.readItemStack(clientdata, version, cache.getLocale());
		cX = clientdata.readUnsignedByte() / 16.0F;
		cY = clientdata.readUnsignedByte() / 16.0F;
		cZ = clientdata.readUnsignedByte() / 16.0F;
	}

}
