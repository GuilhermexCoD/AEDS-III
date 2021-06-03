package src.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import src.controller.hash.Registro;

public class Resposta implements Registro {

    private int idResposta;
    private int idPergunta;
    private int idUsuario;
    private long criacao;
    private short nota;
    private String resposta;
    private boolean ativa;

    public Resposta(int idResposta, int idPergunta, int idUsuario, long criacao, short nota, String resposta,
            boolean ativa) {
        setIdResposta(idResposta);
        setIdPergunta(idPergunta);
        setIdUsuario(idUsuario);
        setCriacao(criacao);
        setNota(nota);
        setResposta(resposta);
        setAtiva(ativa);
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public short getNota() {
        return nota;
    }

    public void setNota(short nota) {
        this.nota = nota;
    }

    public long getCriacao() {
        return criacao;
    }

    public void setCriacao(long criacao) {
        this.criacao = criacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public int getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    @Override
    public int getID() {
        return idResposta;
    }

    @Override
    public void setID(int ID) {
        setIdResposta(ID);
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public byte[] toByteArray() throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(this.idResposta);
        dos.writeInt(this.idPergunta);
        dos.writeInt(this.idUsuario);
        dos.writeLong(this.criacao);
        dos.writeShort(this.nota);
        dos.writeUTF(this.resposta);
        dos.writeBoolean(this.ativa);

        return baos.toByteArray();
    }

    @Override
    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        this.idResposta = dis.readInt();
        this.idPergunta = dis.readInt();
        this.idUsuario = dis.readInt();
        this.criacao = dis.readLong();
        this.nota = dis.readShort();
        this.resposta = dis.readUTF();
        this.ativa = dis.readBoolean();

    }

}